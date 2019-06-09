package com.onedirect.hotelbooking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.onedirect.hotelbooking.impl.RoomServiceImpl;
import com.onedirect.hotelbooking.model.ReservationDetail;
import com.onedirect.hotelbooking.model.Room;
import com.onedirect.hotelbooking.model.RoomDetails;
import com.onedirect.hotelbooking.repository.ReservationDetailsRepository;
import com.onedirect.hotelbooking.repository.RoomRepository;
import com.onedirect.hotelbooking.service.RoomService;

/**
 * @author thenmozhi.a
 */
@RunWith(SpringRunner.class)
public class RoomServiceImplTest {

	@TestConfiguration
	static class RoomServiceImplTestContextConfiguration {

		@Bean
		public RoomService roomService() {
			return new RoomServiceImpl();
		}
	}

	@MockBean
	Room room;
	
	@MockBean
	ReservationDetail reservationDetail;

	@MockBean
	private RoomRepository roomRepository;
	
	@MockBean
	private ReservationDetailsRepository rdr;

	@Autowired
	private RoomService roomService;

	@Before
	public void setUp() {
		List<String> list =new ArrayList<>();
		list.add("double");
		Mockito.when(roomRepository.findAll()).thenReturn(getRoomList());
		Mockito.when(roomRepository.findDistinctType()).thenReturn(list);
		Mockito.when(room.getPrice()).thenReturn(1000);
		Mockito.when(room.getRating()).thenReturn(4.5);
		Mockito.when(roomRepository.findByType(Mockito.anyString())).thenReturn(getRoomList());
	}

	@Test
	public void testGetRoomByType() {
		List<RoomDetails> rooms = roomService.getAllRoomDetails();
		assertEquals(1, rooms.size());
	}

	@Test
	public void testCalculateRoomPrice() {
		int cost = roomService.calculateCost("Non-AC", 2);
		assertEquals(2000, cost);
	}

	private List<Room> getRoomList() {
		List<Room> roomList = new ArrayList<>();
		roomList.add(room);
		return roomList;
	}

}
