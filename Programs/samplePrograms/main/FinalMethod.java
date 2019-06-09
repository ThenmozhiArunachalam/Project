package main;

public class FinalMethod {

	public static void main(String args[]) {
		Base b = new Derived();
		b.foo();
	}

}

class Base {
	//final method can't be override
	private final void foo() {
	}
}

class Derived extends Base {
	public void foo() {
	}
}
