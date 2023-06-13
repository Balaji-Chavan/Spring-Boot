package com.cjss.Task2.controler;

import com.cjss.Task2.model.Marks;
import com.cjss.Task2.model.Subjects;
import com.cjss.Task2.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    
    @Autowired
    SubjectService subjectService;


    @PostMapping("/add")
    public List<Subjects> add(@RequestBody  Subjects s){
        return subjectService.addSubjects(s);
    }

    @GetMapping("/get-all")
    public List<Subjects> getAll(){
        return  subjectService.getAllSubjects();
    }

    @GetMapping("/get-byId/{id}")
    public List<Subjects> getById(@PathVariable String id){
        return  subjectService.getSubjectsById(id);
    }


    @DeleteMapping("/delete-byId/{id}")
    public List<Subjects> delById(@PathVariable String id){
        return  subjectService.deleteById(id);
    }

}
