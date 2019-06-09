package decorator;

public class TomatoPizza extends Decorator {

	public TomatoPizza(Pizza pizza) {
		super(pizza);
		System.out.println("Adding tomato");
	}

	public String getDescription() {
		return tempPizza.getDescription() + " ,Tomato";
	}

	public int getCost() {
		return tempPizza.getCost() + 5;
	}

}
