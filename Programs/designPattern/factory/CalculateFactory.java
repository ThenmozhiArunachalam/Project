package factory;

/* Factory class decides which object you want like state pattern*/

public class CalculateFactory {

	Calculate calculater = null;

	String type;

	public CalculateFactory(String type) {
		this.type = type;
		getCalulation();
	}

	public void getCalulation() {
		switch (type) {
		case "add":
			calculater = new Add();
			break;
		case "divide":
			calculater = new Divide();
			break;
		default:
			System.out.println("Invalid input");
		}
	}
	
	public void calculate(int a,int b) {
		calculater.calculate(a, b);
	}
}
