package com.jpademo.stringsequence.repository;

import com.jpademo.stringsequence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
