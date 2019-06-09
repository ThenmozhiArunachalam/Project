package com.onedirect.hotelbooking.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.onedirect.hotelbooking.model.ReservationDetail;

/**
 * @author thenmozhi.a
 */
public interface ReservationDetailsRepository extends PagingAndSortingRepository<ReservationDetail, Long> {
	
	public ReservationDetail findById(long id);
	
	public ReservationDetail findByRoomId(long id);
	
	public List<ReservationDetail> findByType(String type);
	
}
