package com.pack.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pack.project.Entity.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings, Long>{
	
	@Query(value = "SELECT * FROM BOOKINGS WHERE user_id= ?1",nativeQuery = true)
	List<Bookings> findByUserId(long userid);

	@Query(value = "SELECT * FROM BOOKINGS WHERE worker_id= ?1",nativeQuery = true)
	List<Bookings> findByWorkerId(long workerid);
}
