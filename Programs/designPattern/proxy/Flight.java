package proxy;

public class Flight implements Driven{

	@Override
	public void drive() {
		System.out.println("Reached destination");
	}

}
