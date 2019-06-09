package builder;

public class Phone {
	
	private String os;
	private int ramSize;
	private String processor;
	private double screenSize;
	private  int battery;
	
	public Phone(String os, int ramSize, String processor, double screenSize, int battery) {
		super();
		this.os = os;
		this.ramSize = ramSize;
		this.processor = processor;
		this.screenSize = screenSize;
		this.battery = battery;
	}
	
	@Override
	public String toString() {
		return "Phone [os=" + os + ", ramSize=" + ramSize + ", processor=" + processor + ", screenSize="
				+ screenSize + ", battery=" + battery + "]";
	}

}
