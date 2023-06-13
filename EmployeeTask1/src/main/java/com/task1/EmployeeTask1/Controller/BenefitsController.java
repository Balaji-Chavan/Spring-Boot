package com.task1.EmployeeTask1.Controller;

import com.task1.EmployeeTask1.Model.Benefits;
import com.task1.EmployeeTask1.Model.Location;
import com.task1.EmployeeTask1.Services.BenefitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benefits")
public class BenefitsController {
    @Autowired
    BenefitsService benefitsService;

    @PostMapping("/add")
    public List<Benefits> add(@RequestBody  Benefits e){
        return benefitsService.addBenefits(e);
    }

    @GetMapping("/get-all")
    public List<Benefits> getLocation(){
        return benefitsService.getBenefitsAll();
    }

    @GetMapping("/get-byId/{id}")
    public List<Benefits> getById(@PathVariable String id){
        return  benefitsService.getBenefitsById(id);

    }

    @DeleteMapping("/delete-byId/{id}")
    public List<Benefits> deleteById(@PathVariable String id){
        return benefitsService.deleteBenefitsById(id);
    }

}
