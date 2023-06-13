package com.cjss.Task2.services;

import com.cjss.Task2.model.Staff;
import com.cjss.Task2.model.StudentAttendance;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentAttendanceService {
    List<StudentAttendance> studentAttendanceModel1 = List.of(
            new StudentAttendance("st1", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                   LocalDate.now(),"Present")),
            new StudentAttendance("st2", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                   LocalDate.now(),"Absent")),
            new StudentAttendance("st3", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                   LocalDate.now(),"Absent")),
            new StudentAttendance("st4", Map.of(LocalDate.of(2023, 6, 7),"Absent",
                                                 LocalDate.now(),"Present")),
            new StudentAttendance("st5", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                    LocalDate.now(),"Present")),
            new StudentAttendance("st6", Map.of(LocalDate.of(2023, 6, 7),"Absent",
                                                  LocalDate.now(),"Present")),
            new StudentAttendance("st7", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                  LocalDate.now(),"Present")),
            new StudentAttendance("st8", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                   LocalDate.now(),"Present")),
            new StudentAttendance("st9", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                    LocalDate.now(),"Present")),
            new StudentAttendance("st10", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                     LocalDate.now(),"Absent")),
            new StudentAttendance("st11", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                   LocalDate.now(),"Absent")),
            new StudentAttendance("st12", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                   LocalDate.now(),"Present")),
            new StudentAttendance("st13", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                    LocalDate.now(),"Absent")),
            new StudentAttendance("st14", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                                    LocalDate.now(),"Present")),
            new StudentAttendance("st15", Map.of(LocalDate.of(2023, 6, 7),"Absent",
                                                     LocalDate.now(),"Present"))

    );

    List<StudentAttendance> studentAttendanceModel = new ArrayList<>(studentAttendanceModel1);

    public List<StudentAttendance> addStudentAttendance(StudentAttendance s){
        studentAttendanceModel.add(s);
        return studentAttendanceModel;
    }

    public List<StudentAttendance> getStudentAttendanceById(String id){
        return studentAttendanceModel
                .stream()
                .filter(student -> student.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<StudentAttendance> getAllStudentAttendance(){
        return studentAttendanceModel;
    }

    public List<StudentAttendance> deleteById(String Id){
        List<StudentAttendance> listOfStudentAttendance = studentAttendanceModel
                .stream()
                .filter(Student ->!( Student.getId().equals(Id)))
                .collect(Collectors.toList());
        studentAttendanceModel.clear();
        studentAttendanceModel.addAll(listOfStudentAttendance);
        return studentAttendanceModel;
    }


    public List<String> listOfPrsentStudentId(){
      return  studentAttendanceModel
                .stream()
                .filter(attendance -> attendance.getAttendanceMap().get(LocalDate.now()).equals("Present"))
                .map(attendance -> attendance.getId())
                .collect(Collectors.toList());
    }
}
