package com.chang.cooperationbetweentasks;

import static net.mindview.util.Print.print;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import com.chang.basicthreading.LiftOffRunnable;

class LiftOffRunnableRunner implements Runnable {
	private BlockingQueue<LiftOffRunnable> rockets;

	public LiftOffRunnableRunner(BlockingQueue<LiftOffRunnable> queue) {
		rockets = queue;
	}

	public void add(LiftOffRunnable lo) {
		try {
			rockets.put(lo);
		} catch (InterruptedException e) {
			print("Interrupted during put()");
		}
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				LiftOffRunnable rocket = rockets.take();
				rocket.run(); // Use this thread
			}
		} catch (InterruptedException e) {
			print("Waking from take()");
		}
		print("Exiting LiftOffRunnableRunner");
	}
}

public class TestBlockingQueues {
	static void getkey() {
		try {
			// Compensate for Windows/Linux difference in the
			// length of the result produced by the Enter key:
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (java.io.IOException e) {
			throw new RuntimeException(e);
		}
	}

	static void getkey(String message) {
		print(message);
		getkey();
	}

	static void test(String msg, BlockingQueue<LiftOffRunnable> queue) {
		print(msg);
		LiftOffRunnableRunner runner = new LiftOffRunnableRunner(queue);
		Thread t = new Thread(runner);
		t.start();
		for (int i = 0; i < 5; i++)
			runner.add(new LiftOffRunnable(5));
		getkey("Press ‘Enter’ (" + msg + ")");
		t.interrupt();
		print("Finished " + msg + " test");
	}

	public static void main(String[] args) {
		test("LinkedBlockingQueue", // Unlimited size
				new LinkedBlockingQueue<LiftOffRunnable>());
		test("ArrayBlockingQueue", // Fixed size
				new ArrayBlockingQueue<LiftOffRunnable>(3));
		test("SynchronousQueue", // Size of 1
				new SynchronousQueue<LiftOffRunnable>());
	}
}
