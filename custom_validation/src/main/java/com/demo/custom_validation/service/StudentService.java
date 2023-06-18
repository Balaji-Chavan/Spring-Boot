package com.demo.custom_validation.service;

import com.demo.custom_validation.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    List<Student> studentModel = new ArrayList<>();

    public List<Student> addStudent(Student s){
        studentModel.add(s);
        return  studentModel;
    }

    public List<Student> getAllStudent(){
        return studentModel;
    }

    public List<Student> getStudentById(String id){
        return studentModel
                .stream()
                .filter(std -> std.getId().equals(id))
                .collect(Collectors.toList());
//                .findFirst()
//                .stream().collect(Collectors.toList());
    }

    public Student deleteStudentById(String id){
        List<Student> listStd =
                studentModel
                .stream()
                .filter(std -> (std.getId().equals(id)))
                .collect(Collectors.toList());
        Student std =null;
        if(!listStd.isEmpty()) {
            studentModel.remove(listStd.get(0));
            std=listStd.get(0);
        }

        return std;

    }

}
