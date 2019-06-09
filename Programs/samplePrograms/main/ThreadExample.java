package main;

//1.Extends by Thread class
public class ThreadExample extends Thread {

	public void run() {
		System.out.println("ThreadExample is running");
	}

	public static void main(String args[]) {
		Thread t1 = new Thread(new ThreadExample1());
		t1.start();

		ThreadExample threadExample = new ThreadExample();
		threadExample.start();

		// 3.using annonymous class
		new Thread() {
			@Override
			public void run() {
				System.out.println("annonymous is running");
			}
		}.start();
	}

}

// 2.implements by Runnable interface
class ThreadExample1 implements Runnable {

	@Override
	public void run() {
		System.out.println("ThreadExample1 is running");
	}

}
