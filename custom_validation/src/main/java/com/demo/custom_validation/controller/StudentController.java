package com.demo.custom_validation.controller;


import com.demo.custom_validation.model.Student;
import com.demo.custom_validation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> listOfAllStd =  studentService.getAllStudent();

        if(listOfAllStd.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(listOfAllStd));
    }


    @GetMapping("/get-byid/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id){

        List<Student> listOfStudent = studentService.getStudentById(id);

        if(listOfStudent.size()<=0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(listOfStudent.get(0)));
    }


    @DeleteMapping("/delete-byid/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable String id){
        Student std = studentService.deleteStudentById(id);
        if(std == null){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return  ResponseEntity.ok(std);
    }

@PostMapping("/add")
    public List<Student> add(@Valid @RequestBody Student s){
        return  studentService.addStudent(s);
    }

//    @PostMapping("/add-all")
//    public List<Student> add1(@Valid @RequestBody List<Student> s1){
//        for(Student s : s1){
//
//            add(s);
//        }
//        return studentService.getAllStudent();
//    }




}
