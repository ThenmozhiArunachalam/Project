package factory;

public class Divide implements Calculate {

	@Override
	public void calculate(int a, int b) {
		System.out.println("Divide a and b " + a / b);
	}

}
