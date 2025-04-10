package com.pack.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.Bookings;
import com.pack.project.service.BookingsService;

@RestController
public class BookingsController {
	
	@Autowired
	private BookingsService bookingsService;

	@GetMapping("/user/{userId}/bookings")
	public List<Bookings> getUserBookings(@PathVariable Long userId) {
	    return bookingsService.findByUserId(userId);
	}

	@GetMapping("/worker/{workerId}/bookings")
	public List<Bookings> getWorkerBookings(@PathVariable Long workerId) {
	    return bookingsService.findByWorkerId(workerId);
	}

}
