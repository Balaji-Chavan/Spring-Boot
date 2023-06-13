package com.cjss.Task2.controler;

import com.cjss.Task2.model.Branch;
import com.cjss.Task2.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    BranchService branchService;


    @PostMapping("/add")
    public List<Branch> add(@RequestBody Branch b){
        return branchService.addBranch(b);
    }

    @GetMapping("/get-all")
    public List<Branch> getAll(){
       return  branchService.getAllBranch();
    }

    @GetMapping("/get-byId/{id}")
    public List<Branch> getById(@PathVariable String id){
        return branchService.getBranchById(id);
    }


    @DeleteMapping("/delete-byId/{id}")
    public List<Branch> delById(@PathVariable String id){
        return branchService.deleteById(id);
    }

}
