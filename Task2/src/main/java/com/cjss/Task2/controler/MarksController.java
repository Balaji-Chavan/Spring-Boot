package com.cjss.Task2.controler;

import com.cjss.Task2.model.Branch;
import com.cjss.Task2.model.Marks;
import com.cjss.Task2.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    MarksService marksService;

    @PostMapping("/add")
    public List<Marks> add(@RequestBody Marks m){
        return marksService.addMarks(m);
    }

    @GetMapping("/get-all")
    public List<Marks> getAll(){
        return  marksService.getAllMarks();
    }

    @GetMapping("/get-byId/{id}")
    public List<Marks> getById(@PathVariable String id){
        return  marksService.getMarksById(id);
    }


    @DeleteMapping("/delete-byId/{id}")
    public List<Marks> delById(@PathVariable String id){
        return  marksService.deleteById(id);
    }

}
