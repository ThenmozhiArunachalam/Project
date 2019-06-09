package main;

import java.io.IOException;

public class B extends A {
	String name = "bVar";
	public void foo() {
		System.out.println("B");
	}

	public static void main(String args[]) throws IOException {
		A a = new B();
		System.out.println(a.name);
		a.foo();
		
		String str = "StudyTonight";
		str.concat(".com");
		str = str.toUpperCase();
		str.replace("TONIGHT","today");
		System.out.println(str);
	}

}
