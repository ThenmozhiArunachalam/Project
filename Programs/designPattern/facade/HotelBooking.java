package facade;

public class HotelBooking implements Booking{

	@Override
	public void book() {
		System.out.println("Hotel booked successfully");
	}

}
