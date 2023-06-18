package com.queryDemo.repository;

import com.queryDemo.Entity.Customer;
import com.queryDemo.dto.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.queryDemo.dto.OrderResponse(c.name , p.pname)FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInfo();
}
