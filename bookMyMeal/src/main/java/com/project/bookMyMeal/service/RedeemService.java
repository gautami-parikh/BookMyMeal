package com.project.bookMyMeal.service;
import java.time.Instant;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import com.project.bookMyMeal.dao.RedeemDao;
import com.project.bookMyMeal.dto.Redeemdto;
import com.project.bookMyMeal.model.Coupon;
import com.project.bookMyMeal.model.Status;

@Service
public class RedeemService {
	
	@Autowired
	private RedeemDao redeemdao;
	@Autowired
	private TaskScheduler taskScheduler;
	
	@Autowired
	private HolidayDao holidayDao;
	
	public boolean reedemcoupon(Redeemdto redeemdto) {
		
	      
            
            LocalDate currentdate = LocalDate.now();
            
            
            	Coupon coupon = new Coupon();	//change of code
            	boolean isHoliday =redeemdto.getDate().getDayOfWeek()==DayOfWeek.SUNDAY || redeemdto.getDate().getDayOfWeek()==DayOfWeek.SATURDAY;
            	Optional<Holiday> disabled = holidayDao.findByDate(redeemdto.getDate());

            	if(redeemdto.getStatus().equals(Status.FALSE)&& !(isHoliday || disabled.isPresent())) {
            		//till here
            		coupon.setCouponId(redeemdto.getCouponId());
            		
                	coupon.setDate(currentdate);
                	
            		coupon.setStatus(Status.INPROCESS);  
            		
            		coupon.setEmpId(redeemdto.getEmpId());
            		
            		redeemdao.save(coupon);            		
            		
            		taskScheduler.schedule(() -> {
            		    coupon.setStatus(Status.TRUE);
            		    redeemdao.save(coupon);
            			}, Instant.now().plusSeconds(900));
            		
            		
            		return true;
            	}
				return false; 
            	
            }			
}
