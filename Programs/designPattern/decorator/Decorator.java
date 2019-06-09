package decorator;

//attach a flexible additional responsibilities to an object dynamically
public abstract class Decorator implements Pizza {

	public Pizza tempPizza;

	public Decorator(Pizza pizza) {
		this.tempPizza = pizza;
	}

	@Override
	public String getDescription() {
		return tempPizza.getDescription();
	}

	@Override
	public int getCost() {
		return tempPizza.getCost();
	}

}
