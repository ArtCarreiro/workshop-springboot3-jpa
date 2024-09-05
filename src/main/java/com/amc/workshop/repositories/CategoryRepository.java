package com.amc.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amc.workshop.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{}
