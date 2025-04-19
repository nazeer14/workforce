package com.pack.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.Bookings;
import com.pack.project.service.BookingsService;

@RestController
@RequestMapping("/bookings")
public class BookingsController {
	
	@Autowired
	private BookingsService bookingsService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Bookings>> getAllBooking()
	{
		return ResponseEntity.ok(bookingsService.getAllBookings());
	}
	
	@GetMapping("/getuh")
	public ResponseEntity<List<Bookings>> getUserBookings(@RequestParam Long userId) {
		 return ResponseEntity.ok(bookingsService.findByUserId(userId));
	}

	@GetMapping("/getwh")
	public ResponseEntity<List<Bookings>> getWorkerBookings(@RequestParam Long workerId) {
	    return ResponseEntity.ok(bookingsService.findByWorkerId(workerId));
	}
	
	@PostMapping("entry")
	public ResponseEntity<Bookings> bookingEntry(@RequestBody Bookings booking)
	{
		return ResponseEntity.ok(bookingsService.entry(booking));		
	}

}
