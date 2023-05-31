package com.project.bookMyMeal.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coupon {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
    
		@Column(unique = true)
		private String couponId;
		
		private String empId;
		
		public Status getStatus() {
			return status;
		}
		private LocalDate date;
		
		@Enumerated(EnumType.STRING)
		private Status status;
		
		public void setStatus(Status status) {
			this.status = status;
		}
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
		
		public Coupon(String couponId, String empId, LocalDate date, Status status) {
			super();
			this.couponId = couponId;
			this.empId = empId;
			this.date = date;
			this.status = status;
		}
		public Coupon() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Coupon [couponId=" + couponId + ", EmpId=" + empId + ", date=" + date + ", status=" + status + "]";
		}
		
		
		
		
}
