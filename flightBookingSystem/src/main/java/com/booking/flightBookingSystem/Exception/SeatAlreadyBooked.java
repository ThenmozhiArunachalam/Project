package com.booking.flightBookingSystem.Exception;

public class SeatAlreadyBooked extends Exception {

	private static final long serialVersionUID = -7778665689573201556L;

	public SeatAlreadyBooked() {
		super("Seat already booked");
	}

}
