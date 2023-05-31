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
		
		//change of code
		
		boolean isWeekend = holiday.getdate().getDayOfWeek()==DayOfWeek.SUNDAY || holiday.getdate().getDayOfWeek()==DayOfWeek.SATURDAY;
		Optional<Holiday> disabled = holidaydao.findByDate(holiday.getdate());
		if(disabled.isPresent() || isWeekend) {
			return true;
		}
		return false;
	}
}
