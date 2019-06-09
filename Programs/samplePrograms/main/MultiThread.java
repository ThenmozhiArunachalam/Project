package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiThread implements Runnable {
	String name;
	Thread t;

	MultiThread(String threadname) {
		name = threadname;
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" running");
			}
		} catch (InterruptedException e) {
			System.out.println(name + "Interrupted");
		}
		System.out.println(name + " exiting.");
	}

	public static void main(String args[]) {

		MultiThread thread = new MultiThread("One");
		MultiThread thread1 = new MultiThread("Two");
		MultiThread thread2 = new MultiThread("Three");
		thread.t.start();
		thread1.t.start();
		thread2.t.start();
		try {
			Thread.sleep(10000);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Main thread exiting.");

		/*
		 * What if we call run() method directly instead start() method? Each thread
		 * starts in a separate call stack. Invoking the run() method from main thread,
		 * the run() method goes onto the current call stack rather than at the
		 * beginning of a new call stack.As you can see in the above program that there
		 * is no context-switching because here t3,t4 and t5 will be treated as normal
		 * object not thread object.
		 */
		System.out.println("Calling run method ---------");
		MultiThread thread3 = new MultiThread("One");
		MultiThread thread4 = new MultiThread("Two");
		MultiThread thread5 = new MultiThread("Three");
		thread3.t.run();
		thread4.t.run();
		thread5.t.run();
		/**
		 * The join() method waits for a thread to die. In other words, it causes the
		 * currently running threads to stop executing until the thread it joins with
		 * completes its task. It waits until thread t6 will execute.
		 */
		System.out.println("Join method");
		MultiThread thread6 = new MultiThread("One");
		MultiThread thread7 = new MultiThread("Two");
		MultiThread thread8 = new MultiThread("Three");
		thread6.t.start();
		try {
			thread6.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		thread7.t.start();
		thread8.t.start();

		/*
		 * Each thread have a priority. Priorities are represented by a number between 1
		 * and 10. In most cases, thread schedular schedules the threads according to
		 * their priority (known as preemptive scheduling). But it is not guaranteed
		 * because it depends on JVM specification that which scheduling it chooses.
		 */
		System.out.println("Thread Priority");
		MultiThread thread9 = new MultiThread("One");
		MultiThread thread10 = new MultiThread("Two");
		MultiThread thread11 = new MultiThread("Three");
		thread9.t.setPriority(10);
		thread10.t.setPriority(5);
		thread11.t.setPriority(8);
		thread9.t.start();
		thread10.t.start();
		thread11.t.start();

		System.out.println("Thread Pool");
		ExecutorService executor = Executors.newFixedThreadPool(5);// creating a pool of 5 threads
		for (int i = 0; i < 10; i++) {
			Runnable worker = new ThreadPool("" + i);
			executor.execute(worker);// calling execute method of ExecutorService
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");

	}

}
