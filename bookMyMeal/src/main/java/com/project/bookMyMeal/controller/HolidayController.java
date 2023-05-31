package com.project.bookMyMeal.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookMyMeal.model.Holiday;
import com.project.bookMyMeal.service.HolidayService;


@RestController
public class HolidayController {

	@Autowired
	private HolidayService holidayservice;
	
	@PostMapping("/holiday")
	public ResponseEntity<String> CheckHoliday(@RequestBody Holiday holiday){
		
		boolean isAvailable = holidayservice.CheckHoliday(holiday);
		
		if(isAvailable) {
			return ResponseEntity.ok("Date is Not available");
		}
		return ResponseEntity.badRequest().body("You can Book your Meal");
	}
	
}
