package com.amc.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amc.workshop.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}
