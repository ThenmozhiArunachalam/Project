package com.onedirect.hotelbooking.model;

import org.springframework.stereotype.Component;

/**
 * This class is used for common response purpose
 * @author thenmozhi.a
 */
@Component
public class Response {

	private String status;
	private Object responseData;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object response) {
		this.responseData = response;
	}

}
