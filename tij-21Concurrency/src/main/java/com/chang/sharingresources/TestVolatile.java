package com.chang.sharingresources;

/**
 * 当我们不使用 volatile 关键字的时候： 在线程进入 run()
 * 方法的时候，我们将它复制到线程栈中，与前面的不同的是，前面复制到线程栈的是一个指向堆内存的引用。 在将 stop 复制到线程栈之后，我们操作 stop
 * 就是在线程栈上进行了。 而我们在 main() 方法中，修改的并不是 run() 方法线程栈上的 stop 的值，而在 run()
 * 方法中读取的仍然是线程栈上的 stop。
 * 
 * 当我们使用 volatile 关键字的时候，run() 方法和 stopMe() 方法都是读取主内存中的 stop 的值，所以可以正常运行。
 */
class StopTester implements Runnable {
	private volatile boolean stop = false;

	// private boolean stop = false;
	public void stopMe() {
		stop = true;
	}

	public void run() {
		System.out.println("Thread start.");
		while (!stop) {
		}
		System.out.println("Thread stopped.");
	}
}

public class TestVolatile {
	public static void main(String[] args) throws Exception {
		StopTester tester = new StopTester();
		Thread thread = new Thread(tester);
		thread.start();
		Thread.sleep(1000);
		System.out.println("Try stop...");
		tester.stopMe();
		Thread.sleep(1000);
	}
}
