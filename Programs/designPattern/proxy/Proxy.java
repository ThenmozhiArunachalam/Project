package proxy;

/** provides the control for accessing the original object */
public class Proxy implements Driven {

	Person person;

	public Proxy(Person person) {
		this.person = person;
	}

	@Override
	public void drive() {
		if(person.getRole().equals("Pilot")){
			Flight flight = new Flight();
			flight.drive();
			return;
		}
		System.out.println("Not Authorised to drive");
	}

}
