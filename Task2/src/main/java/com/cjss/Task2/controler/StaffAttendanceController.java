package com.cjss.Task2.controler;

import com.cjss.Task2.model.StaffAttendance;
import com.cjss.Task2.model.StudentAttendance;
import com.cjss.Task2.services.StaffAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff-attendance")
public class StaffAttendanceController {
    @Autowired
    StaffAttendanceService staffAttendanceService;

    @PostMapping("/add")
    public List<StaffAttendance> add(@RequestBody StaffAttendance s){
        return staffAttendanceService.addStaffAttendance(s);
    }

    @GetMapping("/get-all")
    public List<StaffAttendance> getAll(){
        return  staffAttendanceService.getAllStaffAttendance();
    }

    @GetMapping("/get-byId/{id}")
    public List<StaffAttendance> getById(@PathVariable String id){
        return  staffAttendanceService.getStaffAttendanceById(id);
    }


    @DeleteMapping("/delete-byId/{id}")
    public List<StaffAttendance> delById(@PathVariable String id){
        return staffAttendanceService.deleteById(id);
    }


}
