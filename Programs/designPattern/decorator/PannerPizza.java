package decorator;

public class PannerPizza extends Decorator {

	public PannerPizza(Pizza pizza) {
		super(pizza);
		System.out.println("Adding Panner");
	}

	public String getDescription() {
		return tempPizza.getDescription() + " ,Panner";
	}

	public int getCost() {
		return tempPizza.getCost() + 10;
	}
}
