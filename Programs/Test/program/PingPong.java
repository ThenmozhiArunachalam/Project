package program;

public class PingPong extends Thread {
	public void run() {
		System.out.println("ping thread");
	}

	 public static void main(String []args) { Thread pingPong = new PingPong();
	 pingPong.run(); System.out.print("pong"); }}

	// public static void main(String []args) { Thread pingPong = new PingPong();
	// pingPong.start(); System.out.println("pong"); }}

//	public static void main(String[] args) throws InterruptedException {
//		Thread pingPong = new PingPong();
//		pingPong.start();
//		pingPong.join();
//		System.out.println("pong");
//	}
//}
