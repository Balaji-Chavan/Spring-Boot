package com.cjss.Task2.controler;

import com.cjss.Task2.model.Student;
import com.cjss.Task2.model.Subjects;
import com.cjss.Task2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public List<Student> add(@RequestBody Student s){
        return studentService.addStudent(s);
    }

    @GetMapping("/get-all")
    public List<Student> getAll(){
        return  studentService.getAllStudent();
    }

    @GetMapping("/get-byId/{id}")
    public List<Student> getById(@PathVariable String id){
        return  studentService.getStudentById(id);
    }


    @DeleteMapping("/delete-byId/{id}")
    public List<Student> delById(@PathVariable String id){
        return  studentService.deleteById(id);
    }

}
