package com.project.bookMyMeal.dao;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bookMyMeal.model.Holiday;

@Repository
public interface HolidayDao extends JpaRepository<Holiday, Integer>{
	
	Optional<Holiday> findByDate(LocalDate localDate);

}
