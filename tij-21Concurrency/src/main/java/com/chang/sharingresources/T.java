package com.chang.sharingresources;

class T {

	public static boolean asleep = false;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {
				public void run() {

					judge();
				}
			}).start();
		}
		Thread.sleep(3000);
		new Thread(new Runnable() {

			public void run() {
				asleep = true;
				System.out.println("end");
			}
		}).start();

	}

	public static void judge() {
		while (!asleep) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CMS();
		}
	}

	public static void CMS() {
		System.out.println("@");
	}
}
