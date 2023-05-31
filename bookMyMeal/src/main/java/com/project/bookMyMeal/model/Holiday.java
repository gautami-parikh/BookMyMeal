package com.project.bookMyMeal.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate date;

	@Override
	public String toString() {
		return "Holiday [id=" + id + ", holidaydate=" + date + "]";
	}

	public Holiday() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Holiday(int id, LocalDate date) {
		super();
		this.id = id;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getdate() {
		return date;
	}

	public void setdate(LocalDate date) {
		this.date = date;
	}
}
