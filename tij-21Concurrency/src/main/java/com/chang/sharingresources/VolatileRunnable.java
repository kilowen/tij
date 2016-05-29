package com.chang.sharingresources;

public class VolatileRunnable implements Runnable {

	private int id;
	//public volatile boolean stop = false; 在这里设置不起作用
	private StopFlag stopFlag;

	public VolatileRunnable(int iden,StopFlag stopFlag) {
		id = iden;
		this.stopFlag = stopFlag;
	}

	public void run() {
		/*System.out.println("Thread[" + id + "]start--" + isBln());
		if (2 != id) {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (2 == id) {
			setBln(true);
		}
		System.out.println("Thread[" + id + "]end--" + isBln());*/
		if (2 == id) {
			stopFlag.stop();
		}else {
			while (!stopFlag.isStop()){
				/*System.out.println();
				System.out.print(id+"-");*/
			}
			System.out.println(id+"收到信号停止");
		}
		
		
	}
}
