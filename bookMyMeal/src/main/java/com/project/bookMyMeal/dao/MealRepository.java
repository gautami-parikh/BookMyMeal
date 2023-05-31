package com.project.bookMyMeal.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bookMyMeal.Model.Meal;



@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

	List<Meal> findByMealDateBetween(LocalDate fromDate, LocalDate toDate);

}

