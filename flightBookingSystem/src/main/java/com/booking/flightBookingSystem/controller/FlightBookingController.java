package com.booking.flightBookingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.flightBookingSystem.Exception.NoRecordsFound;
import com.booking.flightBookingSystem.Exception.NoSeatsAreBooked;
import com.booking.flightBookingSystem.Exception.SeatAlreadyBooked;
import com.booking.flightBookingSystem.model.Seat;
import com.booking.flightBookingSystem.service.FlightBookingService;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

@RestController
@RequestMapping("flight/booking")
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;

	@GetMapping("seats")
	public ResponseEntity<Object> getSeats() throws NoSeatsAreBooked {
		List<Seat> seats = flightBookingService.getBookedSeats();
		if (seats.isEmpty()) {
			throw new NoSeatsAreBooked();
		}
		return ResponseEntity.ok(seats);
	}

	@GetMapping("seats/{id}")
	public ResponseEntity<Object> getSeat(@PathVariable int id) throws NoRecordsFound {
		Seat seat = flightBookingService.getSeatDetail(id);
		if (seat == null) {
			throw new NoRecordsFound();
		}
		return ResponseEntity.ok(seat);
	}

	@PostMapping("seats")
	public ResponseEntity<Object> addSeat(@RequestBody String input) throws SeatAlreadyBooked {
		JSONObject json = (JSONObject) JSONValue.parse(input);
		Seat seat = new Seat((int) json.get("no"), (String) json.get("type"), (int) json.get("price"));
		return ResponseEntity.ok(flightBookingService.addSeat(seat));
	}

}
