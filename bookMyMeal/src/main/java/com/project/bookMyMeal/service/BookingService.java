package com.project.bookMyMeal.service;
import java.time.LocalDate;


import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookMyMeal.dao.BookingDao;
import com.project.bookMyMeal.dto.BookingRequest;
import com.project.bookMyMeal.model.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao bookingdao;
	
   
	public boolean bookMeal(BookingRequest bookingrequest) {
		/* 	LocalDate currentDate = LocalDate.now();
	        LocalTime currentTime = LocalTime.now();
	     	 Booking booking = new Booking(); 
	        int max=4000,min=1000;	       
	        int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);

	        if ((bookingDate.equals(currentDate.plusDays(1)) && currentTime.isBefore(LocalTime.of(20, 0)))) {
	            booking.setDate(bookingDate);
	            booking.setBookingtime(currentTime);
	            booking.setEmpId(empId);
	            booking.setBookingId(randomWithMathRandom);
	            // Set other properties of the booking entity
	            
	            bookingdao.save(booking);
	            return true;
	        }

	        return false;
	    } */
		
		
		 
		 	int max=4000,min=1000;	       
	        int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
	        LocalTime currentTime = LocalTime.now();
	        LocalDate currentdate = LocalDate.now();
	        // Create a new booking
	        Booking booking = new Booking();
	        if(bookingrequest.getDate().equals(currentdate.plusDays(1)))
	        
	        booking.setBookingId(randomWithMathRandom);
	        booking.setEmployeeId(bookingrequest.getEmployeeId());
	        booking.setDate(bookingrequest.getDate());
	        booking.setTime(currentTime);
	        // Set other properties of the booking as needed
	        
	        bookingdao.save(booking);
	        return true;
	    }
		
}


