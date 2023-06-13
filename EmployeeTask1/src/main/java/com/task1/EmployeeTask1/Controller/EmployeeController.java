package com.task1.EmployeeTask1.Controller;

import com.task1.EmployeeTask1.Model.Benefits;
import com.task1.EmployeeTask1.Services.EmployeeService;
import com.task1.EmployeeTask1.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
   @Autowired
    EmployeeService empService;
    @PostMapping("/add")
    public List<Employee> add(@RequestBody Employee e){
        return empService.addEmp(e);
    }

    @GetMapping("/get-all-emp")
    public List<Employee> getEmp(){
        return empService.getEmpAll();
    }

    @GetMapping("/get-emp-byId/{id}")
    public List<Employee> getEmpById(@PathVariable String id){
        return  empService.getEmpById(id);
    }

    @DeleteMapping("/delete-byId/{id}")
    public List<Employee> deleteById(@PathVariable String id){
        return empService.deleteEmployeeById(id);
    }
}
