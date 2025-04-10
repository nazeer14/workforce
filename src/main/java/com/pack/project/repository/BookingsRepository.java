package com.pack.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pack.project.Entity.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings, Long>{
	
	@Query(value = "SELECT name,userid,workerid FROM BOOKINGS WHERE userid= ?1",nativeQuery = true)
	List<Bookings> findByWorkerId(long userid);

	@Query(value = "SELECT name,userid,workerid FROM BOOKINGS WHERE workerid= ?1",nativeQuery = true)
	List<Bookings>findByUserId(long workerid);
}
