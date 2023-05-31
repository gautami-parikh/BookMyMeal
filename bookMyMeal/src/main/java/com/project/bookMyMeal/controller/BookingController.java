package com.project.bookMyMeal.controller;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookMyMeal.dto.BookingRequest;
import com.project.bookMyMeal.model.Booking;
import com.project.bookMyMeal.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingservice;
	
	@PostMapping("/book")
	public ResponseEntity<String> bookMeal(@RequestBody BookingRequest bookingrequest){
		/*
		 * LocalTime currentTime = LocalTime.now(); LocalDate nextDate =
		 * LocalDate.now().plusDays(1); boolean isBooked =
		 * bookingservice.bookMeal(booking.getBookingId(), booking.getEmpId(), nextDate,
		 * currentTime); if(isBooked) { return
		 * ResponseEntity.ok("Meal Booked Successfully"); } return
		 * ResponseEntity.badRequest().body("Failed to book the meal");
		 */
		
		LocalDateTime currentTime = LocalDateTime.now();
        LocalTime bookingTime = bookingrequest.getTime();

        if (currentTime.getHour() >= 20) {
            return ResponseEntity.badRequest().body("Booking time has expired");
        }
        if (currentTime.toLocalDate().equals(bookingrequest.getDate()) && currentTime.toLocalTime().isAfter(bookingTime)) {
            return ResponseEntity.badRequest().body("Booking time has expired");
        }

        boolean isBooked = bookingservice.bookMeal(bookingrequest);
        
        if (isBooked) {
            return ResponseEntity.ok("Meal booked successfully for " + bookingrequest.getDate());
        } else {
            return ResponseEntity.badRequest().body("Failed to book meal");
        }
    }
		
}

