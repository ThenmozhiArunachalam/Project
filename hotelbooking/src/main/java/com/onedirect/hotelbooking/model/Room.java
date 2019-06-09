package com.onedirect.hotelbooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author thenmozhi.a
 */
@Entity
@Table(name = "room")
public class Room {

	@Id
	private long id;

	private String type;

	private int price;

	private double rating;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public Room() {
		
	}

	public Room(long id, String type, double rating, int price) {
		this.id = id;
		this.type = type;
		this.price = price;
		this.rating = rating;
	}
}
