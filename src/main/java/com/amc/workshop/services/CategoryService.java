package com.amc.workshop.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.amc.workshop.entities.Category;
import com.amc.workshop.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> opt = repository.findById(id);
        return opt.get();
    }

}
