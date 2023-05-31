package com.project.bookMyMeal.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookMyMeal.service.CancelService;


@RestController
@CrossOrigin
public class CancelController {

	@Autowired
	private CancelService cencelservice;
	
	 @PostMapping("/cancel/{bookingId}")
	    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
	       
		 boolean isCanceled = cencelservice.cancelBooking(bookingId);
	        
	        if (isCanceled) {
	            return ResponseEntity.ok("Booking canceled successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Failed to cancel booking");
	        }
	    }
	} 
	
	

