package com.project.bookMyMeal.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookMyMeal.Model.Meal;
import com.project.bookMyMeal.Service.MealService;



@RestController
@RequestMapping("/meals")
public class MealController {
	
    @Autowired
    private MealService mealService;

    @GetMapping("/monthly")
    public List<Meal> getMealsForDateRange(@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        return mealService.getMealsForDateRange(fromDate, toDate);
    }

    @PostMapping
    public Meal bookMeal(@RequestBody Meal meal) {
        return mealService.bookMeal(meal);
    }
}