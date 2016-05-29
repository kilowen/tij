package com.chang.sharingresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {

	
	public static void main(String[] args) {

		//boolean stopFlag = false;
		
		//StopFlag stopFlag= new StopFlag();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new VolatileRunnable(i,new StopFlag()));
		exec.shutdown();

		/*
		 * new VolatileRunnable(1).setBln(true); boolean a = new
		 * VolatileRunnable(2).isBln(); System.out.println(a);
		 */

	}
}
