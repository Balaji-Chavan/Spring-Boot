package com.project.BookMyCinemaProject.controller;

import com.project.BookMyCinemaProject.dto.CustomerModel;
import com.project.BookMyCinemaProject.entity.Customer;
import com.project.BookMyCinemaProject.service.Customerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    Customerservice customerservice;

    @PostMapping("/add")
    public String add(@RequestBody Customer customer){
        return customerservice.addCustomer(customer);
    }

    @GetMapping("/get-all")
    public List<CustomerModel> getAllCustomer(){
        return  customerservice.getAllCustomer();
    }

}
