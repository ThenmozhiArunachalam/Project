package adapter;

/**
 * converts the interface of a class into another interface that a client wants
 */
public class VehicleAdapter implements Vehicle {
	
	Walk walk;
	
	public VehicleAdapter(Walk walk) {
		this.walk = walk;
	}

	@Override
	public void startEngine() {
		walk.go();
	}

}
