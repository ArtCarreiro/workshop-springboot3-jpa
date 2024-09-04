package com.amc.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amc.workshop.entities.Order;
import com.amc.workshop.services.OrderService;

import java.util.List;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    ResponseEntity<List<Order>> response(){
        List<Order> listOrders = orderService.findAll();
        return ResponseEntity.ok().body(listOrders);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Order> responseById(@PathVariable Long id){
        Order orderById = orderService.findById(id);
        return ResponseEntity.ok().body(orderById);
    }


}
