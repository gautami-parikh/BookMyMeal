package com.project.bookMyMeal.dto;

import java.time.LocalDate;


import com.project.bookMyMeal.model.Status;

public class Redeemdto {

	
	private String couponId;
	private String empId;
	private LocalDate date;
	private Status status;
	
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Redeemdto [couponId=" + couponId + ", EmpId=" + empId + ", date=" + date + ", status=" + status + "]";
	}
	public Redeemdto(String couponId, String empId, LocalDate date, Status status) {
		super();
		this.couponId = couponId;
		this.empId = empId;
		this.date = date;
		this.status = status;
	}
	public Redeemdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
