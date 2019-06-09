package main;

public class RuntimeExample {
	public static void main(String args[]) throws Exception {
		Runtime.getRuntime().exec("gedit");// will open a new gedit
		System.out.println(Runtime.getRuntime().availableProcessors()); 
	}
}
