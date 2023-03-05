package com.example.springboot3.controller;

import com.example.springboot3.entity.Customer;
import com.example.springboot3.repo.ICustomerRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/customers")
public class CustomerController {

    private ICustomerRepo customerRepo ;

    public CustomerController(ICustomerRepo customerRepo){
        this.customerRepo = customerRepo ;
    }

    @GetMapping()
    public List<Customer> findAll() {

        return this.customerRepo.findAll() ;
    }


    @GetMapping("/{id}")
    public Optional<Customer> findByName(@PathVariable("id") Integer id ) {

        return this.customerRepo.findById(id);
    }
}
