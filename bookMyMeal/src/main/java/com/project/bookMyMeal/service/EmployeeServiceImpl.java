package com.project.bookMyMeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.bookMyMeal.dao.EmployeeDao;
import com.project.bookMyMeal.dao.LoginDao;
import com.project.bookMyMeal.dto.ChangePasswordDto;
import com.project.bookMyMeal.dto.EmployeeUserDto;
import com.project.bookMyMeal.dto.LoginRequestDto;
import com.project.bookMyMeal.model.EmployeeUser;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	LoginDao loginDao;
	
//	Registration
	@Override
	public void saveEmployee(EmployeeUserDto employeeUserDto) {
		// TODO Auto-generated method stub
		EmployeeUser employeeUser = new EmployeeUser();
		
		employeeUser.setFname(employeeUserDto.getFname());
		employeeUser.setLname(employeeUserDto.getLname());
		employeeUser.setEmail(employeeUserDto.getEmail());
		employeeUser.setMobile(employeeUserDto.getMobile());
		employeeUser.setAddress(employeeUserDto.getAddress());
		employeeUser.setPassword(employeeUserDto.getPassword());
		
		employeeDao.save(employeeUser);

	}

	
	//Login


	@Override
	public String loginEmployee(LoginRequestDto loginRequestDto) {
		// TODO Auto-generated method stub
		String reqEmail = loginRequestDto.getEmail();
		String reqPass = loginRequestDto.getPassword();
		System.out.println("Email:" + reqEmail);
		System.out.println("Password: " + reqPass);
		Optional<EmployeeUser> loginDetail = loginDao.findByEmail(reqEmail);
		
		

		if(loginDetail.isPresent()){
			EmployeeUser employee = loginDetail.get();
			if(employee.getEmail().equals(reqEmail) && employee.getPassword().equals(reqPass)) {
				String id = Long.toString(employee.getId()); 
				return id;
			}
			else {
				return "Invalid Credentials";
			}
		}
			return "User does not exist";
		
			
	}


//Change Password


	@Override
	public ResponseEntity<String> changePassword(ChangePasswordDto changePasswordDto) {
		// TODO Auto-generated method stub
		String user = changePasswordDto.getEmail();
		String old_p = changePasswordDto.getOldPassword();
		String new_p = changePasswordDto.getNewPassword();
		String confirm = changePasswordDto.getConfirmPassword();
		
		
		
		
		Optional<EmployeeUser> changeDetails = loginDao.findByEmail(user);
		
		if(changeDetails.isPresent()) {
			EmployeeUser employee = changeDetails.get();
			
			if(employee.getPassword().equals(old_p)) {
				
					if(new_p.equals(confirm)) {
						
						employee.setPassword(new_p);
						employeeDao.save(employee);
						return ResponseEntity.ok("Successfully updated");
					}else {
				
						return ResponseEntity.badRequest().body("Confirm and new passsword should be same");
					}
			}
					
			else {
					return ResponseEntity.badRequest().body("Old password doesn't mactch");
			}
		}
		
		return ResponseEntity.badRequest().body("User doesn't exists");
	}

	


	

}
