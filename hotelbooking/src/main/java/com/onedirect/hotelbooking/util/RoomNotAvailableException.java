package com.onedirect.hotelbooking.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author thenmozhi.a
 */
@ResponseStatus(value=HttpStatus.OK, reason="Room Already booked")
public class RoomNotAvailableException  extends RuntimeException{

	private static final long serialVersionUID = -9000055300659001040L;

}
