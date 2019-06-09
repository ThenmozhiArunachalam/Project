package com.booking.flightBookingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.booking.flightBookingSystem.Exception.NoSeatsAreBooked;
import com.booking.flightBookingSystem.Exception.SeatAlreadyBooked;
import com.booking.flightBookingSystem.model.Seat;

@Service
public class FlightBookingService {

	private static List<Seat> reservedSeats = new ArrayList<>();
	static int id = 1;

	static {
		reservedSeats.add(new Seat(1, "mid", 5000));
		reservedSeats.add(new Seat(id++, "window", 6000));
		reservedSeats.add(new Seat(id++, "window", 6000));
		reservedSeats.add(new Seat(id++, "window", 10000));
		reservedSeats.add(new Seat(id++, "window", 6000));
		reservedSeats.add(new Seat(id++, "last", 6000));
		reservedSeats.add(new Seat(id++, "lastWindow", 6000));
	}

	public List<Seat> getBookedSeats() throws NoSeatsAreBooked {
		if (reservedSeats.isEmpty()) {
			throw new NoSeatsAreBooked();
		}
		return reservedSeats;
	}

	public Seat getSeatDetail(int id) {
		Seat seats = reservedSeats.parallelStream().filter(e -> e.getNo() == id).findAny().orElse(null);
		return seats;
	}

	public String addSeat(Seat seat) throws SeatAlreadyBooked {
		List<Seat> seats = reservedSeats.parallelStream().filter(e -> e.getNo() == seat.getNo())
				.collect(Collectors.toList());
		if (seats.isEmpty()) {
			reservedSeats.add(seat);
			return "Successfully added";
		} else {
			throw new SeatAlreadyBooked();
		}
	}

}
