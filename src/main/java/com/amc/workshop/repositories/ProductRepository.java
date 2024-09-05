package com.amc.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amc.workshop.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
