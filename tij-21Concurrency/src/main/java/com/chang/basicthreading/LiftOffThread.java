package com.chang.basicthreading;

public class LiftOffThread extends Thread {
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOffThread() {
	}

	public LiftOffThread(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}

	}

}
