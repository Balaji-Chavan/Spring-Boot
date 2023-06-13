package com.cjss.Task2.controler;

import com.cjss.Task2.model.Marks;
import com.cjss.Task2.model.Staff;
import com.cjss.Task2.model.Student;
import com.cjss.Task2.model.StudentAttendance;
import com.cjss.Task2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class Task2Controller {
    @Autowired
    StudentService studentService;

    @Autowired
    StaffService staffService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    StaffAttendanceService staffAttendanceService;

    @Autowired
    StudentAttendanceService studentAttendanceService;

    @Autowired
    MarksService marksService;

    @Autowired
    BranchService branchService;


    //1) Retrieve employee details in year 1
    @GetMapping("/std-year-wise/{year}")
    public List<Student> studentYearWise(@PathVariable int year){

        return studentService.studentListYearWise(year);
    }

    //2) Retrieve staff details who teach year 1
    @GetMapping("/staff-year-wise/{year}")
    public List<Staff>  staffYearWise(@PathVariable int year){
        List<String> ListOfSubIdYearWise = subjectService.subIdListYearWise(year);
       return  staffService.staffYearWise(ListOfSubIdYearWise);
    }


    //3) Retrieve employee who is present today in year 1 and branch CSE
    @GetMapping("/today-std-year-branch-wise/{year}/{branch}")
    public List<Student> presentStdBranchAndyearWise(@PathVariable int year , @PathVariable String branch){
        List<String> listOfPresentStudentId = studentAttendanceService.listOfPrsentStudentId();

        return studentService.presentStdBranchAndYearWise(listOfPresentStudentId ,year,branch);
    }


    //4) Retrieve staff who is present today and who teaches Subject1
    @GetMapping("/today-staff-subjectwise/{subject}")
    public List<Staff> presentStaff(@PathVariable String subject){
        List<String> presentStaffId =staffAttendanceService.presentStaffId();
    return staffService.presentStaff(presentStaffId,subject);
    }


    //5) Retrieve students who are not passed in year 1

    @GetMapping("/failed-std-yearwise/{year}")
    public List<Student> failedStudent(@PathVariable int year){
        List<String> yearWiseStudentIdList = studentService.listOfStdIdYearWise(year);
        List<String> listOfFailedStdId = marksService.listOfFailedStudentId(yearWiseStudentIdList ,year);
  return studentService.failedStudentYearWise(listOfFailedStdId);

    }

//6) Retrieve staff who teaches more than 2 subjects in year 2

    @GetMapping("/staff-teach-morethan-2-sub/{year}")
    public List<Staff> teachMoreThan2Sub(@PathVariable int year){
      List<String> listOfSubIdYearWise = subjectService.subIdListYearWise(year);
         return staffService.staffListTeachesMorethan2subSameYear(listOfSubIdYearWise);
    }

    //7)Retrive all information  by id

    @GetMapping("/get-all-info-by-id/{id}")
    public String getAllStudentInfo(@PathVariable String id){
List<Student> listStd = studentService.getStudentById(id);
List<StudentAttendance> listStdAttendance = studentAttendanceService.getStudentAttendanceById(id);
List<Marks>  listOfMarks = marksService.getMarksById(id);

String s = listStd.get(0)+"\nAttendance Info : \n"+listStdAttendance.get(0)+"\nMarks Info : \n"+listOfMarks.get(0);
return s;
    }
}
