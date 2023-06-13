package com.cjss.Task2.model;

public class Subjects {
    private String subId;
    private String subName;
    private int year;
    private String branchId;
    public Subjects( String subId,String subName, int year, String branchId) {
        super();
        this.subId = subId;
        this.subName = subName;
        this.year = year;
        this.branchId = branchId;
    }
    public String getSubName() {
        return subName;
    }
    public void setSubName(String subName) {
        this.subName = subName;
    }
    public String getSubId() {
        return subId;
    }
    public void setSubId(String subId) {
        this.subId = subId;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
    @Override
    public String toString() {
        return "Subjects [subId=" + subId + ", subName=" + subName + ", year=" + year + ", branchId=" + branchId + "]";
    }



}
