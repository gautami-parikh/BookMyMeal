package com.project.bookMyMeal.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookMyMeal.dto.Redeemdto;
import com.project.bookMyMeal.service.RedeemService;


@RestController
public class RedeemController {

	@Autowired
	private RedeemService redeemservice;
	
	
	@PostMapping("/redeem")
	public ResponseEntity<String> redeemcoupon(@RequestBody Redeemdto redeemdto) {
		
		boolean isRedeemed = redeemservice.reedemcoupon(redeemdto);
		
		
		if(isRedeemed) {
			
			return ResponseEntity.ok("Coupon redeemed Successfully");
			
		}
		return ResponseEntity.badRequest().body("Failed to book the meal");
		
		
		
	}
	
}
