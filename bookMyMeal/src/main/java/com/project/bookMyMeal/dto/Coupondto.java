package com.project.bookMyMeal.dto;

import java.time.LocalDate;

public class Coupondto {

	private int couponId;
	private int EmpId;
	private LocalDate date;
	private boolean status; 
	
	
	@Override
	public String toString() {
		return "Coupondto [couponId=" + couponId + ", EmpId=" + EmpId + ", date=" + date + ", status=" + status + "]";
	}
	public Coupondto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupondto(int couponId, int empId, LocalDate date, boolean status) {
		super();
		this.couponId = couponId;
		EmpId = empId;
		this.date = date;
		this.status = status;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
