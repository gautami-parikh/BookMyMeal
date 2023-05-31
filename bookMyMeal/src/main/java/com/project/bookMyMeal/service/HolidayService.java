package com.project.bookMyMeal.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookMyMeal.dao.HolidayDao;
import com.project.bookMyMeal.model.Holiday;

@Service
public class HolidayService {

	
	@Autowired
	private HolidayDao holidaydao;
	
	public boolean CheckHoliday(Holiday holiday) {
		
		Optional<Holiday> disabled = holidaydao.findByDate(holiday.getdate());
		if(disabled.isPresent()) {
			return true;
		}
		return false;
	}
}
