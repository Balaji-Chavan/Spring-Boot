package com.cjss.Task2.model;

import java.time.LocalDate;
import java.util.Map;

public class StaffAttendance {
    private String staffid;
    private Map<LocalDate,String> staffattendanceMap;
    public StaffAttendance(String staffid, Map<LocalDate, String> staffattendanceMap) {
        super();
        this.staffid = staffid;
        this.staffattendanceMap = staffattendanceMap;
    }
    public String getStaffid() {
        return staffid;
    }
    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }
    public Map<LocalDate, String> getStaffattendanceMap() {
        return staffattendanceMap;
    }
    public void setStaffattendanceMap(Map<LocalDate, String> staffattendanceMap) {
        this.staffattendanceMap = staffattendanceMap;
    }


}
