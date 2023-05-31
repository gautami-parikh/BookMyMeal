package com.project.bookMyMeal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bookMyMeal.model.EmployeeUser;

@Repository
public interface LoginDao extends JpaRepository<EmployeeUser, Long>{
	Optional<EmployeeUser> findByEmail(String email);
}
