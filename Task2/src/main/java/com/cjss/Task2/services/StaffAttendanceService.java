package com.cjss.Task2.services;

import com.cjss.Task2.model.StaffAttendance;
import com.cjss.Task2.model.StudentAttendance;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StaffAttendanceService {
List<StaffAttendance> staffAttendanceModel1 = List.of(
        new StaffAttendance("T1", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                               LocalDate.now(),"Present")),
        new StaffAttendance("T2", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                               LocalDate.now(),"Present")),
        new StaffAttendance("T3", Map.of(LocalDate.of(2023, 6, 7),"Absent",
                                               LocalDate.now(),"Absent")),
        new StaffAttendance("T4", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                               LocalDate.now(),"Present")),
        new StaffAttendance("T5", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                               LocalDate.now(),"Present")),
        new StaffAttendance("T6", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                               LocalDate.now(),"Present")),
        new StaffAttendance("T7", Map.of(LocalDate.of(2023, 6, 7),"Absent",
                                               LocalDate.now(),"Present")),
        new StaffAttendance("T8", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                               LocalDate.now(),"Absent")),
        new StaffAttendance("T9", Map.of(LocalDate.of(2023, 6, 7),"Present",
                                               LocalDate.now(),"Present"))

);
    List<StaffAttendance> staffAttendanceModel = new ArrayList<>(staffAttendanceModel1);

    public List<StaffAttendance> addStaffAttendance(StaffAttendance s){
        staffAttendanceModel.add(s);
        return  staffAttendanceModel;
    }

    public List<StaffAttendance> getStaffAttendanceById(String id){
        return  staffAttendanceModel
                .stream()
                .filter(staff -> staff.getStaffid().equals(id))
                .collect(Collectors.toList());
    }

    public List<StaffAttendance> getAllStaffAttendance(){
        return  staffAttendanceModel;
    }

    public List<StaffAttendance> deleteById(String Id){
        List<StaffAttendance> listOfStaffAttendance =  staffAttendanceModel
                .stream()
                .filter(staff ->!( staff.getStaffid().equals(Id)))
                .collect(Collectors.toList());
        staffAttendanceModel.clear();
        staffAttendanceModel.addAll(listOfStaffAttendance);
        return  staffAttendanceModel;
    }

    public List<String> presentStaffId(){
       return staffAttendanceModel
                .stream()
                .filter(attendance -> attendance.getStaffattendanceMap().get(LocalDate.now()).equals("Present"))
                .map(attendance -> attendance.getStaffid())
                .collect(Collectors.toList());
    }
}
