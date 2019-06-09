package com.booking.flightBookingSystem.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(NoSeatsAreBooked.class)
	public ResponseEntity<ExceptionResponse> handleNoSeatsAreBooked(NoSeatsAreBooked exception,
			HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.OK);
	}

	@ExceptionHandler(NoRecordsFound.class)
	public ResponseEntity<ExceptionResponse> handleNoRecordsFound(NoRecordsFound exception, HttpServletRequest req) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(exception.getMessage());
		response.callerURL(req.getRequestURI());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.OK);
	}

	@ExceptionHandler(SeatAlreadyBooked.class)
	public ResponseEntity<ExceptionResponse> handleSeatAlreadyBookedResponse(SeatAlreadyBooked exception,
			HttpServletRequest req) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(req.getRequestURI());
		return new ResponseEntity<ExceptionResponse>(error, HttpStatus.OK);
	}

}
