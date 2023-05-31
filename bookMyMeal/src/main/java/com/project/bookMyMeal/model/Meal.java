package com.project.bookMyMeal.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meals")

public class Meal {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id")
    private String employeeId;
    
    @Column(name = "meal_date")
    private LocalDate mealDate;

    @Column(name = "from_date")
    private String fromDate;
    
    @Column(name = "to_date")
    private String toDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}

	public LocalDate getMealDate() {
		return mealDate;
	}

	public void setMealDate(LocalDate mealDate) {
		this.mealDate = mealDate;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
    

    
}
