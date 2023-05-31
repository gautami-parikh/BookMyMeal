package com.project.bookMyMeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookMyMeal.dao.EmployeeDao;
import com.project.bookMyMeal.dto.EmployeeUserDto;
import com.project.bookMyMeal.model.EmployeeUser;
import com.project.bookMyMeal.service.EmployeeService;

@RestController
@RequestMapping("/bookMeal")
public class RegistrationController {
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeDao dao;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody EmployeeUserDto employeeUserDto){
		
		EmployeeUser userExists = dao.findByEmail(employeeUserDto.getEmail());
		
		if(userExists != null) {
			return ResponseEntity.badRequest().body("User already exists");
		}
		
		employeeService.saveEmployee(employeeUserDto);
		return ResponseEntity.ok("Registration Success");
	}
}
