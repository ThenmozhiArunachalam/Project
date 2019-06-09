package main;

public class PassByValue {

	public static void main(String args[]) {
		// Java creates a copy of the variable being passed in the method and then do
		// the manipulations. Hence the change is not reflected in the main method.
		int x = 5;
		System.out.println("inside before Main method " + x);
		change(x);
		System.out.println("inside after Main method " + x);

		// test point reference
		Test test = new Test();
		test.setI(5);
		test.setJ(10);
		System.out.println("inside before Main method " + test.toString());
		change(test);
		System.out.println("inside after Main method " + test.toString());

	}

	private static void change(int x) {
		x = 10;
		System.out.println("inside change method " + x);
	}

	private static void change(Test test) {
		test.setI(10);
		test.setJ(20);
		System.out.println("inside change method " + test.toString());
	}

}

class Test {

	int i;
	int j;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "Test [i=" + i + ", j=" + j + "]";
	}

}