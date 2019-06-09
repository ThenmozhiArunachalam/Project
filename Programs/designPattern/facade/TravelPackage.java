package facade;

/**
 * just provide a unified and simplified interface to a set of interfaces in a
 * subsystem, therefore it hides the complexities of the subsystem from the
 * client Ex: TravelPackage = flightBooking+ hotelBooking+TrasferBooking(car);
 */

public class TravelPackage implements Booking{

	@Override
	public void book() {
		
		FlightBooking flight = new FlightBooking();
		flight.book();
		
		HotelBooking hotel = new HotelBooking();
		hotel.book();
		
		TransferBooking transfer = new TransferBooking();
		transfer.book();
		
		System.out.println("TravelPackage booked successfully");
	}
	

}
