package com.cjss.Task2.services;

import com.cjss.Task2.model.Student;
import com.cjss.Task2.model.Subjects;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    List<Student> studentModel1 = List.of(
            new Student("st1","Aniket","a@gamil.com", 1, "CSE"),
            new Student("st2", "Amit", "a1@gamil.com", 1, "CSE"),
            new Student("st3", "Kumar", "k@gamil.com", 2, "CSE"),
            new Student("st4", "Vishnu", "v@gamil.com", 2, "CSE"),
            new Student("st5", "Raj", "raj@gamil.com", 3, "CSE"),
            new Student("st6", "Shivam", "shivam@gamil.com", 3, "CSE"),
            new Student("st7", "Balaji", "b@gamil.com", 4, "CSE"),
            new Student("st8", "Shubham", "s1@gamil.com", 4, "CSE"),
            new Student("st9", "Sagar", "sagar@gamil.com", 1, "IT"),
            new Student("st10", "Prakash", "p@gamil.com", 1, "MECH"),
            new Student("st11", "Aniket", "a11@gamil.com", 1, "CIVIL"),
            new Student("st12", "Shubham1", "s11@gamil.com", 1, "ENTC"),
            new Student("st13", "Balaji1", "b11@gamil.com", 1, "CIVL"),
            new Student("st14", "AmitKumar", "ak@gamil.com", 1, "MECH"),
            new Student("st15", "Sanket", "sanket@gamil.com", 1, "ENTC")
    );

    List<Student> studentModel = new ArrayList<>(studentModel1);
    public List<Student> addStudent(Student s){
       studentModel.add(s);
        return studentModel;
    }

    public List<Student> getStudentById(String id){
        return studentModel
                .stream()
                .filter(branch -> branch.getStdId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudent(){
        return studentModel;
    }

    public List<Student> deleteById(String Id){
        List<Student> listOfStudent = studentModel
                .stream()
                .filter(Student ->!( Student.getStdId().equals(Id)))
                .collect(Collectors.toList());
       studentModel.clear();
       studentModel.addAll(listOfStudent);
        return studentModel;
    }

    public List<Student> studentListYearWise(int i){
        return studentModel
                .stream()
                .filter(student -> student.getYear() == i)
                .collect(Collectors.toList());
    }

    public List<Student> presentStdBranchAndYearWise(List<String> listOfPresentStdId ,int year, String branch){
     return   studentModel
                .stream()
                .filter(student -> student.getBranch().equals(branch) && student.getYear() == year)
                .filter(student ->  listOfPresentStdId .contains(student.getStdId()))
                .collect(Collectors.toList());
    }

    public List<String> listOfStdIdYearWise(int year){
       return  studentModel
                .stream()
                .filter(student -> student.getYear() == year)
                .map(student -> student.getStdId())
                .collect(Collectors.toList());
    }

    public List<Student> failedStudentYearWise(List<String> failedstdIdList){
       return studentModel
                .stream()
                .filter(student ->failedstdIdList.contains(student.getStdId()))
                .collect(Collectors.toList());
    }
}
