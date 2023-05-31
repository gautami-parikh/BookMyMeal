package com.project.bookMyMeal.dao;

import java.time.LocalDate;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookMyMeal.model.*;
import java.util.List;
import java.util.Optional;


public interface BookingDao extends JpaRepository<Booking, Integer> {

	boolean existsByDate(LocalDate date);
	
	 Optional<Booking> findByBookingId(int bookingId);

	/*
	 * Booking findByBookingtime(LocalTime time);
	 */}
