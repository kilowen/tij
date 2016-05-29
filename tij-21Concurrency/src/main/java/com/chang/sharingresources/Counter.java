package com.chang.sharingresources;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter{

	public int count = 0;

	public synchronized void inc() {
		count++;
	}

	public static void main(String[] args) throws InterruptedException {

		// 同时启动1000个线程，去进行i++计算，看看实际结果
		ExecutorService executor = Executors.newCachedThreadPool();
		final CountDownLatch cdl = new CountDownLatch(100000);
		final Counter counter = new Counter();
		for (int i = 0; i < 100000; i++) {
			executor.execute(new Thread( new Runnable() {
				public void run() {
					counter.inc();
					cdl.countDown();
				}
			}));
		}
		cdl.await();
		// 这里每次运行的值都有可能不同,可能为1000
		System.out.println("运行结果:Counter.count=" + counter.count);
		executor.shutdown();
	}

}