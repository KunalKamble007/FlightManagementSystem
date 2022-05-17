package com.capg.controller;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.RecordAlreadyPresentException;
import com.capg.exception.RecordNotFoundException;
import com.capg.model.Booking;
import com.capg.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingservice;
	
	
	@PostMapping("/createBooking")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addBooking(@RequestBody Booking booking) {
		bookingservice.createBooking(booking);
		
		
	}
	@GetMapping("/readAllbooking")
	public Iterable<Booking> readAllBookings(){
		return bookingservice.displayAllBooking();
		
		
	}
	@PutMapping("/updatebooking")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyBooking(@RequestBody Booking booking) {
		bookingservice.updateBooking(booking);
		
	}
	@GetMapping("/searchbooking/{Id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Booking> findBookingById(@PathVariable ("Id") BigInteger bookingId){
		return  bookingservice.findBookingById(bookingId);
		
	}
	
	@DeleteMapping("/deletebooking/{Id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteBookingById(@PathVariable ("Id") BigInteger bookingId){
		bookingservice.deleteBooking(bookingId);
		
	}
	
}
