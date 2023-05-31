package com.project.bookMyMeal.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(unique = true)
	    private int bookingId;
	    
	    private int employeeId;
	    
	    private LocalDate date;
	    
	    private LocalTime time;
	    
	    // Add other properties as needed
	    
	    // Getters and setters
	    
	    public Long getId() {
	        return id;
	    }
	    
	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public int getBookingId() {
	        return bookingId;
	    }
	    
	    public void setBookingId(int bookingId) {
	        this.bookingId = bookingId;
	    }
	    
	    public int getEmployeeId() {
	        return employeeId;
	    }
	    
	    public void setEmployeeId(int employeeId) {
	        this.employeeId = employeeId;
	    }
	    
	    public LocalDate getDate() {
	        return date;
	    }
	    
	    public void setDate(LocalDate date) {
	        this.date = date;
	    }
	    
	    public LocalTime getTime() {
	        return time;
	    }
	    
	    public void setTime(LocalTime time) {
	        this.time = time;
	    }

}
