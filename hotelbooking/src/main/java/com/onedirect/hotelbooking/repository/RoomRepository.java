package com.onedirect.hotelbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.onedirect.hotelbooking.model.Room;

/**
 * @author thenmozhi.a
 */
public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {

	public List<Room> findByType(String type);

	@Query("SELECT DISTINCT r.type FROM Room r")
	public List<String> findDistinctType();
	
	public Room findById(long id);
	
	public List<Room> findAll();
	
}
