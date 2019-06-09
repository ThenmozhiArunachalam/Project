package com.onedirect.hotelbooking.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onedirect.hotelbooking.model.ReservationDetail;
import com.onedirect.hotelbooking.model.Room;
import com.onedirect.hotelbooking.model.RoomDetails;
import com.onedirect.hotelbooking.repository.ReservationDetailsRepository;
import com.onedirect.hotelbooking.repository.RoomRepository;
import com.onedirect.hotelbooking.service.RoomService;

/**
 * This service implementation class used to get all rooms details, find the pricing
 * details
 * @author thenmozhi.a
 *
 */
@Component
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ReservationDetailsRepository bookedDetailsRepository;

	@Override
	public List<RoomDetails> getAllRoomDetails() {
		List<RoomDetails> roomDetailsList = new ArrayList<>();
		List<String> roomTypes = roomRepository.findDistinctType();
		for (String type : roomTypes) {
			List<Room> rooms = roomRepository.findByType(type);
			double rating = getAvgRating(rooms);
			int price = rooms.get(0).getPrice();
			roomDetailsList.add(new RoomDetails(type, rating, price));
		}
		return roomDetailsList;
	}

	@Override
	public List<ReservationDetail> getTimeSlots(String type) {
		return bookedDetailsRepository.findByType(type);
	}

	@Override
	public int calculateCost(String type, int noOfDays) {
		List<Room> rooms = roomRepository.findByType(type);
		int price = rooms.get(0).getPrice();
		return price * noOfDays;
	}



	private double getAvgRating(List<Room> rooms) {
		return rooms.stream().mapToDouble(Room::getRating).average().orElse(0);
	}

}
