package com.onedirect.hotelbooking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.onedirect.hotelbooking.impl.ReservationServiceImpl;
import com.onedirect.hotelbooking.model.ReservationDetail;
import com.onedirect.hotelbooking.model.Room;
import com.onedirect.hotelbooking.repository.ReservationDetailsRepository;
import com.onedirect.hotelbooking.repository.RoomRepository;
import com.onedirect.hotelbooking.service.ReservationService;
import com.onedirect.hotelbooking.util.RoomNotAvailableException;

/**
 * @author thenmozhi.a
 */
@RunWith(SpringRunner.class)
public class ReservationServiceImplTests {

	@TestConfiguration
	static class ReservationServiceConfig {
		@Bean
		public ReservationService getReservationService() {
			return new ReservationServiceImpl();
		}
	}

	@Autowired
	private ReservationService reservationService;

	@MockBean
	private RoomRepository roomRepository;

	@MockBean
	private ReservationDetailsRepository rdr;

	@MockBean
	Room room;

	@MockBean
	ReservationDetail reservationDetail;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate startDate = LocalDate.parse("2018-05-16", formatter);
	LocalDate endDate = LocalDate.parse("2018-05-16", formatter);

	@Before
	public void setUp() {

		List<Room> rooms = new ArrayList<>();
		rooms.add(room);
		List<ReservationDetail> reservationDetails = new ArrayList<>();
		reservationDetails.add(reservationDetail);
		Mockito.when(roomRepository.findByType(Mockito.anyString())).thenReturn(rooms);
		Mockito.when(room.getId()).thenReturn(1l);
		Mockito.when(rdr.findByType(Mockito.anyString())).thenReturn(reservationDetails);
		Mockito.when(reservationDetail.getRoomId()).thenReturn(2l);
		Mockito.when(reservationDetail.getStartDate()).thenReturn(startDate);
		Mockito.when(reservationDetail.getEndDate()).thenReturn(endDate);
	}

	@Test
	public void shouldReserveRoom() {
		reservationService.reserveRoom("double", startDate, endDate);
		Mockito.verify(rdr, times(1)).save(Mockito.any());
	}

	@Test(expected = RoomNotAvailableException.class)
	public void shouldThrowRoomNotAvailableException() {
		Mockito.when(room.getId()).thenReturn(1l);
		Mockito.when(reservationDetail.getRoomId()).thenReturn(1l);
		reservationService.reserveRoom("double", startDate, endDate);
	}

}
