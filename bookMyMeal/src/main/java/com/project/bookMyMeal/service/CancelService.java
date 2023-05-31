package com.project.bookMyMeal.service;

import java.time.LocalDate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookMyMeal.dao.BookingDao;
import com.project.bookMyMeal.model.Booking;

@Service
public class CancelService {
	
	@Autowired
	private BookingDao bookingdao;

	public boolean cancelBooking(int bookingId) {	
		/*
		 * LocalTime currenttime = LocalTime.now(); Booking booking = new Booking();
		 * LocalTime bookingtime = booking.getBookingtime();
		 * if(bookingdao.existsById(bookingId) &&
		 * currenttime.isBefore(bookingtime.plusHours(24))) {
		 * 
		 * bookingdao.deleteById(bookingId); return true; }
		 * 
		 * return false;
		 */
		
		Optional<Booking> bookingOptional = bookingdao.findByBookingId(bookingId);

		
		 	
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            LocalDate currentDate = LocalDate.now();
            // Perform any necessary checks or business logic for cancellation
            
            // Example: Check if the booking can be canceled before a certain time
            if (booking.getDate().isAfter(currentDate.minusDays(1))) {
                bookingdao.delete(booking);
                return true;
            }
        }

        return false;
    }
}
	
	
	

