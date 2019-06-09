package decorator;

public class PlainPizza implements Pizza {

	@Override
	public String getDescription() {
		return "plain pizza";
	}

	@Override
	public int getCost() {
		return 20;
	}

}
