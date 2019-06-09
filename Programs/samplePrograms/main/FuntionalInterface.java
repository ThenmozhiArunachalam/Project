package main;

@FunctionalInterface
public interface FuntionalInterface {

	public void doWork();

	public default void display() {
		System.out.println("Hi");
	}
}
