package program;

class RunnableDemo implements Runnable {
	public void run() {
		System.out.print(" Inside Runnable");
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		new MyThread1().start();
		new MyThread1(new RunnableDemo()).start();
	}
}
