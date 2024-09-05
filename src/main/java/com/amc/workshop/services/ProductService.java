package com.amc.workshop.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amc.workshop.entities.Product;
import com.amc.workshop.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> opt = repository.findById(id); 
        return opt.get();
    }

}
