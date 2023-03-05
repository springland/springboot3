package com.example.springboot3.repo;

import com.example.springboot3.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo  extends JpaRepository<Customer, Integer> {


}
