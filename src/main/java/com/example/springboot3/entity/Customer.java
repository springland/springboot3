package com.example.springboot3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



@Entity(name = "customer")
@Data
public class Customer {
    @Id
    Integer id ;

    String name ;
}
