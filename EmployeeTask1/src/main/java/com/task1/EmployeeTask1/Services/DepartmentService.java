package com.task1.EmployeeTask1.Services;

import com.task1.EmployeeTask1.Model.Benefits;
import com.task1.EmployeeTask1.Model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    List<Department> deptModel = List.of(new Department("10", "Engineering"),
                                         new Department("11","Medical"),
                                         new Department("12","Finance"));

    public List<Department> addDepartment(Department e){
        deptModel.add(e);
        return deptModel;
    }

    public List<Department> getDepartmentAll(){

        return  deptModel;
    }

    public List<Department> getDepartmentById(String id){
        return   deptModel
                .stream()
                .filter(department-> department.getDeptId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Department> deleteDepartmentById(String id){
        List<Department> ls  =   deptModel
                .stream()
                .filter(benefits -> !(benefits.getDeptId().equals(id)))
                .collect(Collectors.toList());

        deptModel.clear();
        deptModel.addAll(ls);
        return  deptModel;
    }

}
