package com.jpademo.stringsequence.services;

import com.jpademo.stringsequence.entity.Employee;
import com.jpademo.stringsequence.model.EmployeeModel;
import com.jpademo.stringsequence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
@Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(EmployeeModel employeeModel){
        Employee employee = new Employee(employeeModel.getId(),
                                         employeeModel.getName(),
                                         employeeModel.getSalary()
                                           );

        employeeRepository.save(employee);
    }

    public List<EmployeeModel> getAllEmployee(){

        List<Employee> listOfEmployee=  employeeRepository.findAll();

        if(listOfEmployee.size()>0){
            return   listOfEmployee
                    .stream()
                    .map(employee -> {
                        EmployeeModel sm = new EmployeeModel(employee.getId(),
                                                             employee.getName(),
                                                             employee.getSalary()
                                                              );
                        return  sm;
                    }).collect(Collectors.toList());
          /*
           List<EmployeeModel> listOfEmployeeModel = new ArrayList<>();
           listOfEmployee
           .forEach(employee -> {
                EmployeeModel sm = new EmployeeModel(employee.getId(),
                                                             employee.getName(),
                                                             employee.getSalary()
                                                              );
           listOfEmployeeModel.add(sm);
            });
            return  listOfEmployeeModel;    */
        }
        return null;
    }


    public ResponseEntity<EmployeeModel> getEmployeeById(String id){
        Optional<Employee> optionalEmployeeEntity = employeeRepository.findById(id);
        if(optionalEmployeeEntity.isPresent()){
            Employee employee = optionalEmployeeEntity.get();
            EmployeeModel sm = new EmployeeModel(employee.getId(),
                                                 employee.getName(),
                                                employee.getSalary()
                                                  );
            return  ResponseEntity.of(Optional.of(sm));

        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    public ResponseEntity<Optional<Void>> deleteEmployeeById(String id){
        Optional <Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            employeeRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public void updateEmployee(EmployeeModel employeeModel , String id){
        Optional<Employee> optionalEmployee =   employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
                 employee.setName(employeeModel.getName());
                 employee.setSalary(employeeModel.getSalary());

            employeeRepository.save(employee);
        }
    }

}
