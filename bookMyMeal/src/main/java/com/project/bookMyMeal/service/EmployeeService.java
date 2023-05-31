package com.project.bookMyMeal.service;

import org.springframework.http.ResponseEntity;

import com.project.bookMyMeal.dao.EmployeeDao;
import com.project.bookMyMeal.dto.ChangePasswordDto;
import com.project.bookMyMeal.dto.EmployeeUserDto;
import com.project.bookMyMeal.dto.LoginRequestDto;
import com.project.bookMyMeal.model.EmployeeUser;


public interface EmployeeService {
	void saveEmployee(EmployeeUserDto employeeUserDto);
	String loginEmployee(LoginRequestDto loginRequestDto);
	ResponseEntity<String> changePassword(ChangePasswordDto changePasswordDto);
	
}
