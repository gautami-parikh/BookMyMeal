package com.project.bookMyMeal.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookMyMeal.dto.ChangePasswordDto;
import com.project.bookMyMeal.dto.LoginRequestDto;

import com.project.bookMyMeal.model.EmployeeUser;
import com.project.bookMyMeal.service.EmployeeService;

@RestController
@RequestMapping("/bookMeal")
public class LoginController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
    public void loginEmployee(@RequestBody LoginRequestDto loginRequestDto) {
    	employeeService.loginEmployee(loginRequestDto);
    }
	
	@PostMapping("/change")
	public void changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
		employeeService.changePassword(changePasswordDto);
	}
    
}
