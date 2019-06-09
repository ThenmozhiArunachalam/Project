package program;

public class MyThread1 extends Thread 
{ 
	MyThread1() {} 
	MyThread1(Runnable r) {super(r); } 
  public void run() { 
    System.out.print("Inside Thread ");
  } 
} 

