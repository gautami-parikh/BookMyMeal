package com.project.bookMyMeal.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookMyMeal.Model.Meal;
import com.project.bookMyMeal.repo.MealRepository;

import jakarta.transaction.Transactional;

@Service
public class MealService {
	
    @Autowired
    private MealRepository repo;

    @Transactional
    public List<Meal> getMealsForDateRange(LocalDate fromDate, LocalDate toDate) {
        return repo.findByMealDateBetween(fromDate, toDate);
    }


    @Transactional
    public Meal bookMeal(Meal meal) {
        return repo.save(meal);
    }
}
