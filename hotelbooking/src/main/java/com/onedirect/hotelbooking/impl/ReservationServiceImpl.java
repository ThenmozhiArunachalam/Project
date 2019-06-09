package com.onedirect.hotelbooking.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.onedirect.hotelbooking.model.ReservationDetail;
import com.onedirect.hotelbooking.model.Room;
import com.onedirect.hotelbooking.repository.ReservationDetailsRepository;
import com.onedirect.hotelbooking.repository.RoomRepository;
import com.onedirect.hotelbooking.service.ReservationService;
import com.onedirect.hotelbooking.util.RoomNotAvailableException;

/**
 * This service implementation class used to reserve available rooms
 * @author thenmozhi.a
 *
 */
@Component
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ReservationDetailsRepository reservationDetailsRepository;

	@Override
	public ReservationDetail reserveRoom(String type, LocalDate startDate, LocalDate endDate) {
		List<ReservationDetail> bookedDetails = getAvailableRooms(type, startDate, endDate);
		if (bookedDetails.isEmpty()) {
			throw new RoomNotAvailableException();
		}
		return reserve(startDate, endDate, bookedDetails);
	}

	@Transactional(isolation = Isolation.SERIALIZABLE)
	public ReservationDetail reserve(LocalDate startDate, LocalDate endDate, List<ReservationDetail> reservationDetailsToBeReserved) {
		boolean booked = false;
		ReservationDetail reservationDetail = null;
		for (ReservationDetail reservationDetailToReserve : reservationDetailsToBeReserved) {
			ReservationDetail bookDetail = reservationDetailsRepository.findById(reservationDetailToReserve.getId());
			if (bookDetail == null) {
				reservationDetail = addReservation(startDate, endDate, reservationDetailToReserve);
				booked = true;
			} else {
				if (checkForAvailablity(startDate, endDate, bookDetail)) {
					reservationDetail = addReservation(startDate, endDate, reservationDetailToReserve);
					booked = true;
				}
			}
		}
		if (!booked) {
			throw new RoomNotAvailableException();
		}
		return reservationDetail;
	}

	private ReservationDetail addReservation(LocalDate startDate, LocalDate endDate, ReservationDetail bookedDetail) {
		ReservationDetail reservation = new ReservationDetail();
		reservation.setStartDate(startDate);
		reservation.setEndDate(endDate);
		reservation.setType(bookedDetail.getType());
		reservation.setRoomId(bookedDetail.getRoomId());
		return reservationDetailsRepository.save(reservation);
	}

	public List<ReservationDetail> getAvailableRooms(String type, LocalDate startDate, LocalDate endDate) {
		List<ReservationDetail> reservationDetails = new ArrayList<>();
		List<ReservationDetail> reservedRoomDetailList = reservationDetailsRepository.findByType(type);
		List<Room> totalRooms = roomRepository.findByType(type);
		List<Long> roomIds = totalRooms.stream().map(Room::getId).collect(Collectors.toList());
		List<Long> bookedRoomIds = reservedRoomDetailList.stream().map(ReservationDetail::getRoomId)
				.collect(Collectors.toList());
		roomIds.removeAll(bookedRoomIds);
		if (!roomIds.isEmpty()) {
			ReservationDetail reservationDetail = new ReservationDetail();
			reservationDetail.setType(type);
			reservationDetail.setRoomId(roomIds.get(0));
			reservationDetails.add(reservationDetail);
		} else {
			for (ReservationDetail reservationDetail : reservedRoomDetailList) {
				if (checkForAvailablity(startDate, endDate, reservationDetail)) {
					reservationDetails.add(reservationDetail);
				}
			}
		}
		return reservationDetails;
	}

	private boolean checkForAvailablity(LocalDate startDate, LocalDate endDate, ReservationDetail bookedDetail) {
		boolean available = true;
		List<LocalDate> dateToBook = getDates(startDate, endDate);
		List<LocalDate> dateReserved = getDates(bookedDetail.getStartDate(), bookedDetail.getEndDate());
		for (LocalDate ld : dateToBook) {
			if (dateReserved.contains(ld)) {
				available = false;
			}
		}
		return available;
	}

	private List<LocalDate> getDates(LocalDate begin, LocalDate end) {

		long numOfDaysBetween = ChronoUnit.DAYS.between(begin, end) + 1;
		return IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> begin.plusDays(i))
				.collect(Collectors.toList());
	}

}
