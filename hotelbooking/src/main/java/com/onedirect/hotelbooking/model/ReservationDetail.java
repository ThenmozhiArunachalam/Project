package com.onedirect.hotelbooking.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author thenmozhi.a
 */
@Entity
@Table(name="reservationDetails")
public class ReservationDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private long roomId;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String type;
	

	public long getRoomId() {
		return roomId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
