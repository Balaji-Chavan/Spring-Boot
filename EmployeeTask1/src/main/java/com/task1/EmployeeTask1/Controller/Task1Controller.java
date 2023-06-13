package com.task1.EmployeeTask1.Controller;

import com.task1.EmployeeTask1.Model.Employee;
import com.task1.EmployeeTask1.Services.BenefitsService;
import com.task1.EmployeeTask1.Services.DepartmentService;
import com.task1.EmployeeTask1.Services.EmployeeService;
import com.task1.EmployeeTask1.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class Task1Controller {
    @Autowired
    BenefitsService benefitsService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    LocationService locationService;

    @Autowired
    EmployeeService employeeService;


    //a) Retrieve all employees in India

    @GetMapping("/all-emp-countrywise/{country}")
    public List<Employee> allCountryWiseEmployee(@PathVariable String country){

        List<String> listOfLocationId = locationService.listOfLocationId(country);

       return   employeeService.countryWiseEmployee(listOfLocationId);
    }

    //b) Retrieve employees who are in Chennai or Hyderabad
    @GetMapping("all-emp-citywise/{city1}/{city2}")
    public List<Employee> hello(@PathVariable  String city1 , @PathVariable String city2){
        List<String> listOFLocationId = locationService.listOfLocationId(city1 ,city2);

        return employeeService.countryWiseEmployee(listOFLocationId);
    }


  //  c) Retrieve employees who have Benefits and display benefits details
@GetMapping("/emp-with-benefit")
    public String empwithBenefit(){

        return employeeService.employeeWithBenefits();

}


//d) Retrieve employee details -  employeeId, employeeName, Salary, deptName, locationName, locationCountry
@GetMapping("/emp-required-detail")
    public String empdetail(){
 return employeeService.empRequiredDeatil();
}



// 2.e) Retrieve employees who are in Chennai and India
    @GetMapping("/all-emp-cityandcountrywise/{city}/{country}")
    public List<Employee> empAll(@PathVariable String city , @PathVariable String country){
      return employeeService.empCityAndCountryWise(city ,country);
    }

}
