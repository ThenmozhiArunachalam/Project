package com.booking.flightBookingSystem.model;

public class Seat {

	private int no;

	private String type;

	private int price;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seat [no=" + no + ", type=" + type + ", price=" + price + "]";
	}

	public Seat(int no, String type, int price) {
		super();
		this.no = no;
		this.type = type;
		this.price = price;
	}
}
