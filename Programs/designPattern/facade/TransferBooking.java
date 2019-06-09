package facade;

public class TransferBooking implements Booking{

	@Override
	public void book() {
		System.out.println("Car booked to transfer");
	}

}
