package com.onedirect.hotelbooking.service;

import java.time.LocalDate;

import com.onedirect.hotelbooking.model.ReservationDetail;

/**
 * This service class used to reserve available rooms
 * @author thenmozhi.a
 */
public interface ReservationService {
	
	/**
	* reserves the Available Rooms
	* @param type
	* @param startDate
	* @param endDate
	* @return The reserved room Details
	*/
	public ReservationDetail reserveRoom(String type, LocalDate startDate, LocalDate endDate);

}
