package com.jpa.crud.JpaCrudDemo.controller;

import com.jpa.crud.JpaCrudDemo.entity.StudentEntity;
import com.jpa.crud.JpaCrudDemo.model.Response;
import com.jpa.crud.JpaCrudDemo.model.StudentModel;
import com.jpa.crud.JpaCrudDemo.repository.StudentRepo;
import com.jpa.crud.JpaCrudDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public void add(@RequestBody StudentModel studentModel){
        studentService.addStudent(studentModel);
    }

    @GetMapping("/get-all")
    public List<StudentModel> getAll(){
       return studentService.getAllStudent();
    }


    @GetMapping("/get-byid/{id}")
    public ResponseEntity<StudentModel> getById(@PathVariable int id){
       return studentService.getStudentById(id);
    }



    @DeleteMapping("/delete-byid/{id}")
    public ResponseEntity<Optional<Void>> deleteById(@PathVariable int id){
         return studentService.deleteStudentById(id);
    }

    @PutMapping("/update-student/{id}")
    public void update(@RequestBody StudentModel studentModel , @PathVariable int id){
        studentService.updateStudent(studentModel,id);
    }


    @GetMapping("/get-info/{branch}")
    public List<StudentModel> getInfoBranchWise(@PathVariable String branch){

        return studentService.getinfoBranchWise(branch);
    }

       @GetMapping("/get-response/{branch}")
    public List<Response> getParticularInfo(@PathVariable String branch){

        return studentService.getResponse(branch);
    }

@GetMapping("/get-orderBy")
    public List<StudentModel> orderby(){
        return studentService.orderByName();
}

}
