package com.cjss.Task2.services;

import com.cjss.Task2.model.Staff;
import com.cjss.Task2.model.Subjects;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {
    List<Staff> staffModel1 = List.of(new Staff("T1", "Umesh", "u@gmail.com", List.of(new Subjects("s2", "Subject2", 3, "a3"))),
            new Staff("T2", "Sakhare", "s@gmail.com", List.of(new Subjects("s1", "Subject1", 2, "a1"),
                    new Subjects("s6", "Subject5", 2, "a1"),
                    new Subjects("s12", "Subject11", 2, "a1"))),
            new Staff("T3", "Deepak", "d@gmail.com", List.of(new Subjects("s3", "Subject3", 2, "a2"),
                    new Subjects("s4", "Subject3", 2, "a1"))),
            new Staff("T4", "Vijay", "v@gmail.com", List.of(new Subjects("s5", "Subject4", 1, "a4"),
                    new Subjects("s11", "Subject10", 3, "a4"))),
            new Staff("T5", "Mayur", "m@gmail.com", List.of(new Subjects("s7", "Subject6", 3, "a1"),
                    new Subjects("s9", "Subject8", 4, "a1"))),
            new Staff("T6", "kumar", "k@gmail.com", List.of(new Subjects("s8", "Subject7", 1, "a1"))),
            new Staff("T7", "Amit", "a@gmail.com", List.of(new Subjects("s10", "Subject9", 3, "a1"))),
            new Staff("T8", "Suresh", "suresh@gmail.com", List.of(new Subjects("s13", "Subject1", 2, "a2"))),
            new Staff("T9", "Avinash", "avi@gmail.com", List.of(new Subjects("s14", "Subject1", 2, "a3"))));



    List<Staff> staffModel = new ArrayList<>(staffModel1);
    public List<Staff> addStaff(Staff s) {
        staffModel.add(s);
        return staffModel;
    }

    public List<Staff> getStaffById(String id) {
        return staffModel
                .stream()
                .filter(staff -> staff.getStaffId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Staff> getAllStaff() {
        return staffModel;
    }

    public List<Staff> deleteById(String Id) {
        List<Staff> listOfStudent = staffModel
                .stream()
                .filter(staff -> !(staff.getStaffId().equals(Id)))
                .collect(Collectors.toList());
        staffModel.clear();
        staffModel.addAll(listOfStudent);
        return staffModel;
    }


    public List<Staff> staffYearWise(List<String> listOfSubId) {
        List<Staff> staffList = new ArrayList<>();

        staffModel
                .stream()
                .forEach(staff -> {
                    staff.getLsub().forEach(sub -> {
                        if (listOfSubId.contains(sub.getSubId()) && !(staffList.contains(staff))) {
                            staffList.add(staff);
                        }
                    });
                });

        return staffList;
    }


    public List<Staff> presentStaff(List<String> presentStaffIdList, String subName) {
        List<Staff> presentStaff = new ArrayList<>();
        staffModel
                .forEach(staff -> {
                    staff.getLsub().forEach(subject -> {

                        if (presentStaffIdList.contains(staff.getStaffId()) && subject.getSubName().equals(subName)) {
                            presentStaff.add(staff);
                        }
                    });


                });
        return presentStaff;
    }


    public List<Staff> staffListTeachesMorethan2subSameYear(List<String> listOfSubIdYearWise) {
        List<Subjects> subList = new ArrayList<>();
        List<Staff> staffList = new ArrayList<>();

        staffModel
                .stream()
                .forEach(staff -> {
                    staff.getLsub().forEach(subject -> {
                        if (listOfSubIdYearWise.contains(subject.getSubId())) {
                            subList.add(subject);
                        }
                    });
                    if (subList.size() > 2) {
                        staffList.add(staff);
                    }
                   subList.clear();
                });

        return  staffList;
    }
}