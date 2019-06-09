package program;
public class MyThread implements Runnable { 
 	public void run() {
 		System.out.println("My thread is running.");
 		throw new RuntimeException();
 	}
 	public static void main(String[] args) {
 		Thread thread = new Thread(new MyThread());
 		thread.start();
 		System.out.println("Main method ends.");
 	}
}