package com.task1.EmployeeTask1.Controller;

import com.task1.EmployeeTask1.Model.Department;
import com.task1.EmployeeTask1.Model.Location;
import com.task1.EmployeeTask1.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {
@Autowired
DepartmentService departmentService;

    @PostMapping("/add")
    public List<Department> add(@RequestBody Department e){
        return departmentService.addDepartment(e);
    }

    @GetMapping("/get-all")
    public List<Department> getDepartment(){
        return departmentService.getDepartmentAll();
    }

    @GetMapping("/get-byId/{id}")
    public List<Department> getById(@PathVariable String id){
        return  departmentService.getDepartmentById(id);

    }

    @DeleteMapping("/delete-byId/{id}")
    public List<Department> deleteById(@PathVariable String id){
        return departmentService.deleteDepartmentById(id);
    }


}
