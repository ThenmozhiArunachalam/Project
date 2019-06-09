package com.booking.flightBookingSystem.Exception;

public class NoRecordsFound extends Exception {

	private static final long serialVersionUID = 113912697682984492L;

	public NoRecordsFound() {
		super("No recods found for given id");
	}

}
