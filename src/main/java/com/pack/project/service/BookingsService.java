package com.pack.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.project.Entity.Bookings;
import com.pack.project.repository.BookingsRepository;

@Service
public class BookingsService {
	@Autowired
	private BookingsRepository bookingsRepository;
	
	public List<Bookings> getAllBookings()
	{
		
		return bookingsRepository.findAll();
	}
	
	public List<Bookings> findByUserId(long id)
	{
		return bookingsRepository.findByUserId(id);
	}
	public List<Bookings> findByWorkerId(long id)
	{
		return bookingsRepository.findByWorkerId(id);
		
	}
	
	public Bookings entry(Bookings entry)
	{
		return bookingsRepository.save(entry);
	}
}
