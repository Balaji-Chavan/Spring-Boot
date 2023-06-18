package com.jpademo.stringsequence.controller;

import com.jpademo.stringsequence.model.EmployeeModel;
import com.jpademo.stringsequence.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/add")
    public void add(@RequestBody EmployeeModel employeeModel){
         employeeService.addEmployee(employeeModel);
    }

    @GetMapping("/get-all")
    public List<EmployeeModel> getAll(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/get-byid/{id}")
    public ResponseEntity<EmployeeModel> getByID(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/delete-byid/{id}")
    public ResponseEntity<Optional<Void>> deleteById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/update-byid/{id}")
    public void updateByID(@RequestBody EmployeeModel employeeModel , @PathVariable String id){
        employeeService.updateEmployee(employeeModel,id);
    }

}
