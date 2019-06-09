package com.booking.flightBookingSystem.Contrller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.booking.flightBookingSystem.controller.FlightBookingController;
import com.booking.flightBookingSystem.model.Seat;
import com.booking.flightBookingSystem.service.FlightBookingService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightBookingController.class, secure = false)
public class FlightBookingControllerTests {

	private List<Seat> seats = new ArrayList<>();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FlightBookingService service;

	@Test
	public void shouldReturnAllReservedSeats() throws Exception {
		seats.add(new Seat(1, "window", 6000));
		Mockito.when(service.getBookedSeats()).thenReturn(seats);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/flight/booking/seats")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals("[{\"no\": 1,\"type\": \"window\",\"price\": 6000}]",
				mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void shouldThrowNoSetsAreBookedException() throws Exception {
		Mockito.when(service.getBookedSeats()).thenReturn(seats);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/flight/booking/seats")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals("{\"errorMessage\":\"No seats are booked\",\"requestedURI\":\"/flight/booking/seats\"}",
				mvcResult.getResponse().getContentAsString());

	}

}
