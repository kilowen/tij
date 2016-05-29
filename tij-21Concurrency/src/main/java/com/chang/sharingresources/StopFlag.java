package com.chang.sharingresources;

public class StopFlag {

	private volatile boolean stop = false;

	public boolean isStop() {
		return stop;
	}

	public void stop() {
		this.stop = true;
	}

}
