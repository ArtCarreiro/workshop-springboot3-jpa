package com.amc.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amc.workshop.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{}
