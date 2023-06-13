package com.task1.EmployeeTask1.Controller;

import com.task1.EmployeeTask1.Model.Employee;
import com.task1.EmployeeTask1.Model.Location;
import com.task1.EmployeeTask1.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("location")
public class LocationController {
    @Autowired
    LocationService  locationService;

    @PostMapping("/add")
    public List<Location> add(@RequestBody Location e){
        return locationService.addLocation(e);
    }

    @GetMapping("/get-all")
    public List<Location> getLocation(){
        return locationService.getLocationAll();
    }

    @GetMapping("/get-byId/{id}")
    public List<Location> getById(@PathVariable String id){
        return  locationService.getLocationById(id);

    }

    @DeleteMapping("/delete-byId/{id}")
    public List<Location> deleteById(@PathVariable String id){
       return locationService.deleteLocationById(id);
    }


}
