package com.habay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habay.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
