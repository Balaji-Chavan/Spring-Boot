package com.queryDemo.controller;

import com.queryDemo.Entity.Customer;
import com.queryDemo.dto.OrderRequest;
import com.queryDemo.dto.OrderResponse;
import com.queryDemo.repository.CustomerRepository;
import com.queryDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/placeorder")
    public Customer add(@RequestBody OrderRequest request){
        Customer c = (Customer) request.getCustomer();
        return  customerRepository.save(c);
    }


    @GetMapping("/find-all-orders")
    public List<Customer> getAll(){
        return  customerRepository.findAll();
    }

    @GetMapping("/get-field")
    public List<OrderResponse> getInfo(){
        return  customerRepository.getJoinInfo();
    }
}
