package com.cjss.Task2.controler;

import com.cjss.Task2.model.Staff;
import com.cjss.Task2.model.Student;
import com.cjss.Task2.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService staffService;

    @PostMapping("/add")
    public List<Staff> add(@RequestBody Staff s){
        return staffService.addStaff(s);
    }

    @GetMapping("/get-all")
    public List<Staff> getAll(){
        return  staffService.getAllStaff();
    }

    @GetMapping("/get-byId/{id}")
    public List<Staff> getById(@PathVariable String id){
        return  staffService.getStaffById(id);
    }


    @DeleteMapping("/delete-byId/{id}")
    public List<Staff> delById(@PathVariable String id){
        return  staffService.deleteById(id);
    }

}
