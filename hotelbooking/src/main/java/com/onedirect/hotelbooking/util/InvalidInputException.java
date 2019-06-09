package com.onedirect.hotelbooking.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author thenmozhi.a
 */
@ResponseStatus(value=HttpStatus.OK, reason="Invalid input")
public class InvalidInputException extends RuntimeException{

	private static final long serialVersionUID = -7371115942240276295L;

}
