package com.project.bookMyMeal.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.bookMyMeal.model.Coupon;

public interface RedeemDao extends JpaRepository<Coupon, Integer>{

}
