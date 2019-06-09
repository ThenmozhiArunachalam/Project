package com.onedirect.hotelbooking.service;

import java.util.List;

import com.onedirect.hotelbooking.model.ReservationDetail;
import com.onedirect.hotelbooking.model.RoomDetails;

/**
 * This service class used to get all room details, find the pricing
 * details
 * @author thenmozhi.a
 */
public interface RoomService {

	/**
	 * Get the Room Details alone with Price And Rating
	 * @return List<RoomDetails>
	 */
	public List<RoomDetails> getAllRoomDetails();

	/**
	 * Get available time slots for type
	 * @return List<ReservationDetail>
	 */
	public List<ReservationDetail> getTimeSlots(String type);

	/**
	 * Calculate the price for particular room
	 * @return total cost
	 */
	public int calculateCost(String type, int noOfDays);
}
