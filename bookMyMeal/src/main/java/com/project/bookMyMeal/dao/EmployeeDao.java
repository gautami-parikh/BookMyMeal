package com.project.bookMyMeal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bookMyMeal.model.EmployeeUser;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeUser, Long>{
	EmployeeUser findByEmail(String email);
	
	
}
