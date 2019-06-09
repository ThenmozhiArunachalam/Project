package com.onedirect.hotelbooking.model;

/**
 * @author thenmozhi.a
 */
public class RoomDetails {

	public String getRoomType() {
		return roomType;
	}

	public double getRating() {
		return rating;
	}

	public int getPrice() {
		return price;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private String roomType;

	private double rating;

	private int price;

	public RoomDetails(String roomType, double rating, int price) {
		this.roomType = roomType;
		this.rating = rating;
		this.price = price;
	}

}
