package com.task1.EmployeeTask1.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.task1.EmployeeTask1.Model.Benefits;
import com.task1.EmployeeTask1.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    BenefitsService benefitsService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    LocationService locationService;
    List<Employee> employeeModel = List.of(new Employee("100", "Ajay",30000, "1", "10", List.of("20","21")),
     new Employee("101", "vijay",40000, "2", "11", List.of("21","22")),
    new Employee("102", "jay",30000, "3", "10", List.of("20","22")),
    new Employee("103", "Raj",50000, "1", "12", List.of("20","21")),
    new Employee("104", "Tushar",30000,"2", "12", List.of("20","21","22")),
    new Employee("105", "Shivam",50000,"3", "11", List.of()));

    public List<Employee> addEmp(Employee e){
        employeeModel.add(e);
        return employeeModel;
    }

    public List<Employee> getEmpAll(){
    return  employeeModel;
    }

    public List<Employee> getEmpById(String id){
        return employeeModel
                .stream()
                .filter(emp -> emp.getEmployeeId().equals(id))
                .collect(Collectors.toList());

    }

    public List<Employee> deleteEmployeeById(String id){
        List<Employee> ls  =   employeeModel
                .stream()
                .filter(employee-> !(employee.getEmployeeId().equals(id)))
                .collect(Collectors.toList());

        employeeModel.clear();
        employeeModel.addAll(ls);
        return  employeeModel;
    }


    public List<Employee> countryWiseEmployee(List<String> listOfLocationId){

        return employeeModel
                .stream()
                .filter(emp -> listOfLocationId.contains(emp.getLocationId()))
                .collect(Collectors.toList());
    }


    public String employeeWithBenefits(){
        List<String> lll=new ArrayList<>();
        employeeModel
                .stream()
                .filter(emp -> emp.getBenefitId().size()>0)
                .forEach(emp -> {
                  lll.add(emp.toString());
                  lll.add("\n");
                    emp.getBenefitId()
                            .forEach(bid ->{
                                benefitsService.benefitsModel
                                        .stream()
                                        .filter(benefit -> benefit.getBenefitId().equals(bid))
                                        .forEach(benefit -> {
                                            lll.add(benefit.toString());
                                            lll.add("\n");
                                        });

                            });

                    lll.add("\n\n\n\n");
                });

    String s1 ="";
        for (String s:lll) {
            s1+=s;
        }
        return s1;
    }


    public String empRequiredDeatil(){
        List<String>  ls = new ArrayList<>();
        employeeModel
                .stream()
                .forEach(emp ->{
                    String s1 = "\nEmployeeId : "+emp.getEmployeeId()+
                            "\nEmployeeName : "+emp.getEmployeeName()+
                            "\nSalary : "+emp.getSalary();
                      ls.add(s1);
                    departmentService.deptModel
                            .stream()
                            .filter(dept -> dept.getDeptId().equals(emp.getDeptId()))
                            .forEach(dept -> {
                               String s2 = "\nDepartment Name : "+dept.getDeptName();
                               ls.add(s2);
                            });
                    locationService.locationModel
                            .stream()
                            .filter(location -> location.getLocationId().equals(emp.getLocationId()))
                            .forEach( location ->{
                                String s3 = "\nLocationName : "+location.getLocationName()+
                                        "\nLocationCountry : "+location.getLocationCountry();

                                ls.add(s3);
                            });

            ls.add("\n\n\n");
                });
        String s4 ="";
        for (String s1: ls) {
            s4=s4+s1;}
          return s4;
    }


    public List<Employee> empCityAndCountryWise(String city , String country){
        List<String> listOfLocationId = locationService.cityAndCountryWiseLocationId(city,country);

       return  employeeModel
                .stream()
                .filter(emp -> listOfLocationId.contains(emp.getLocationId()))
                .collect(Collectors.toList());
    }
}
