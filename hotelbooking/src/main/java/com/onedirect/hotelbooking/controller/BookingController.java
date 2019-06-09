package com.onedirect.hotelbooking.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onedirect.hotelbooking.model.ReservationDetail;
import com.onedirect.hotelbooking.model.Response;
import com.onedirect.hotelbooking.model.RoomDetails;
import com.onedirect.hotelbooking.service.ReservationService;
import com.onedirect.hotelbooking.service.RoomService;
import com.onedirect.hotelbooking.util.InvalidInputException;
import com.onedirect.hotelbooking.util.RoomNotAvailableException;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

/**
 * This is the controller class for hotel room booking
 * 
 * @author thenmozhi.a
 *
 */
@RestController
@RequestMapping("/hotel/booking")
public class BookingController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private ReservationService bookingService;

	/**
	 * Get the Room Details alone with Price And Rating
	 */
	@GetMapping("/v1/getAllRoomDetails")
	public Response getAllRoomDetails() {
		Response response = null;
		try {
			List<RoomDetails> roomDetails = roomService.getAllRoomDetails();
			response = buildSuccessResponse(roomDetails);
		} catch (Exception e) {
			response = buildErrorResponse(e);
		}
		return response;
	}

	/**
	 * Get available time slots for type
	 * 
	 * @param type
	 */
	@GetMapping("/v1/getTimeSlots")
	public Response getTimeSlots(@RequestParam String type) {
		Response response = null;
		try {
			if (type == null)
				throw new InvalidInputException();
			List<ReservationDetail> reservedDetails = roomService.getTimeSlots(type);
			response = buildSuccessResponse(reservedDetails);
		} catch (Exception e) {
			response = buildErrorResponse(e);
		}
		return response;
	}

	/**
	 * Calculate the price for particular room
	 * 
	 * @param inputJson
	 */
	@PostMapping("/v1/calculateCost")
	public Response calculateCost(@RequestBody String inputJson) {
		Response response = null;
		try {
			JSONObject json = (JSONObject) JSONValue.parse(inputJson);
			String type = (String) json.get("type");
			int noOfDays = (int) json.get("noOfDays");
			if (type == null || noOfDays == 0)
				throw new InvalidInputException();
			int totalCost = roomService.calculateCost(type, noOfDays);
			response = buildSuccessResponse(totalCost);
		} catch (Exception e) {
			response = buildErrorResponse(e);
		}
		return response;
	}

	/**
	 * reserves the Available Rooms
	 * 
	 * @param inputJson
	 */
	@PostMapping("/v1/reserveRoom")
	public Response reserveRoom(@RequestBody String inputJson) {
		Response response = null;
		try {
			JSONObject json = (JSONObject) JSONValue.parse(inputJson);
			String type = (String) json.get("type");
			String startDateString = json.get("startDate").toString();
			String endDateString = json.get("endDate").toString();
			if (type == null || startDateString == null || endDateString == null)
				throw new InvalidInputException();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate startDate = LocalDate.parse(startDateString, formatter);
			LocalDate endDate = LocalDate.parse(endDateString, formatter);
			ReservationDetail reservationDetail = bookingService.reserveRoom(type, startDate, endDate);
			response = buildSuccessResponse(reservationDetail);
		} catch (RoomNotAvailableException e) {
			response = buildErrorResponse("Room Already booked");
		} catch (Exception e) {
			response = buildErrorResponse(e);
		}
		return response;
	}

	public Response buildErrorResponse(Object e) {
		Response response = new Response();
		response.setStatus("OK");
		response.setResponseData(e);
		return response;
	}

	public Response buildSuccessResponse(Object value) {
		Response response = new Response();
		response.setStatus("Success");
		response.setResponseData(value);
		return response;
	}

}
