package com.booking.flightBookingSystem.Exception;

/**
 * @author thenmozhi.a
 */
public class NoSeatsAreBooked extends Exception {

	private static final long serialVersionUID = -6844853891830927942L;

	public NoSeatsAreBooked() {
		super("No seats are booked");
	}

}
