package com.cjss.Task2.model;

import java.time.LocalDate;
import java.util.Map;

public class StudentAttendance {
    private String id;
    private Map<LocalDate,String> attendanceMap;




    public StudentAttendance(String id, Map<LocalDate, String> attendanceMap) {
        super();
        this.id = id;
        this.attendanceMap = attendanceMap;
    }




    public String getId() {
        return id;
    }




    public void setId(String id) {
        this.id = id;
    }




    public Map<LocalDate, String> getAttendanceMap() {
        return attendanceMap;
    }




    public void setAttendanceMap(Map<LocalDate, String> attendanceMap) {
        this.attendanceMap = attendanceMap;
    }

    @Override
    public String toString() {
        return "StudentAttendance{" +
                "id='" + id + '\'' +
                ", attendanceMap=" + attendanceMap +
                '}';
    }
}
