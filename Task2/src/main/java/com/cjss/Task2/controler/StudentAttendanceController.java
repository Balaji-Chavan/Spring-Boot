package com.cjss.Task2.controler;

import com.cjss.Task2.model.Staff;
import com.cjss.Task2.model.StudentAttendance;
import com.cjss.Task2.services.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/std-attendance")
public class StudentAttendanceController {

    @Autowired
    StudentAttendanceService studentAttendanceService;

    @PostMapping("/add")
    public List<StudentAttendance> add(@RequestBody StudentAttendance s){
        return studentAttendanceService.addStudentAttendance(s);
    }

    @GetMapping("/get-all")
    public List<StudentAttendance> getAll(){
        return  studentAttendanceService.getAllStudentAttendance();
    }

    @GetMapping("/get-byId/{id}")
    public List<StudentAttendance> getById(@PathVariable String id){
        return  studentAttendanceService.getStudentAttendanceById(id);
    }


    @DeleteMapping("/delete-byId/{id}")
    public List<StudentAttendance> delById(@PathVariable String id){
        return  studentAttendanceService.deleteById(id);
    }


}
