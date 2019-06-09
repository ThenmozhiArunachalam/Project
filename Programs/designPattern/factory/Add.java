package factory;

public class Add implements Calculate {

	@Override
	public void calculate(int a, int b) {
		System.out.println("Add a and b " + a + b);
	}

}
