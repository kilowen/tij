package com.chang.basicthreading;

public class LiftOffTest {

	public static void main(String[] args) {
		LiftOffRunnable liftOff = new LiftOffRunnable();
		//liftOff.run();
		
		Thread t = new Thread(liftOff);
		t.start();
		
		
		/*LiftOffThread liftOffThread = new LiftOffThread();
		liftOffThread.start();*/
		
		
	}
}
