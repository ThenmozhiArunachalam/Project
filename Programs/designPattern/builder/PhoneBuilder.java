package builder;

/**
 * construct a complex object from simple objects using step-by-step approach
 */

public class PhoneBuilder {

	private String os;
	private int ramSize;
	private String processor;
	private double screenSize;
	private int battery;

	public PhoneBuilder setOs(String os) {
		this.os = os;
		return this;
	}

	public PhoneBuilder setRamSize(int ramSize) {
		this.ramSize = ramSize;
		return this;
	}

	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}

	public PhoneBuilder setScreenSize(double screenSize) {
		this.screenSize = screenSize;
		return this;
	}

	public PhoneBuilder setBattery(int battery) {
		this.battery = battery;
		return this;
	}

	public Phone getPhone() {
		return new Phone(os, ramSize, processor, screenSize, battery);
	}

}
