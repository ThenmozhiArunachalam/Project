package facade;

public class FlightBooking implements Booking{

	@Override
	public void book() {
		System.out.println("Flight booked successfully");
	}

}
