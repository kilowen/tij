
package com.chang.nlc;

import static net.mindview.util.Print.print;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	public static void main(String[] args) {
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
			public void run() {
				System.out.println("自己会结束吗?");
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					print("barrier-action sleep interrupted");
				}
			}
		});
		for (int i = 0; i < N; i++)
			exec.execute(new Writer(barrier));
			//new Writer(barrier).start();
	}

	static class Writer extends Thread {
		private CyclicBarrier cyclicBarrier;

		public Writer(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			try {
				while (!Thread.interrupted()) {
					System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
					Thread.sleep(1000);// 以睡眠来模拟写入数据操作
					//System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
					cyclicBarrier.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			//System.out.println("所有线程写入完毕，继续处理其他任务...");
		}
	}
}
