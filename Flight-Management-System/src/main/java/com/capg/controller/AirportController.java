package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.exception.RecordNotFoundException;
import com.capg.model.Airport;
import com.capg.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {
	
	@Autowired
	private AirportService airportService;

	@PostMapping("/add")
	@ExceptionHandler(RecordNotFoundException.class)
	public void addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
		
	}
	
	@GetMapping("/get/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airport viewAirport(@PathVariable("id") String airportCode) {
		
		return airportService.viewAirport(airportCode);
	}
	
	
	@GetMapping("/allairport")
	public Iterable<Airport> viewAllAirport(){	
		
		return airportService.viewAllAirport();
		
	}
	
	@PutMapping("/update")
	@ExceptionHandler(RecordNotFoundException.class)
	public void updateAirport(@RequestBody Airport airport) {
		
		airportService.updateAirport(airport);
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteAirport(@PathVariable("id") String airportCode) {
		
		airportService.deleteAirport(airportCode);
		
	}
}
