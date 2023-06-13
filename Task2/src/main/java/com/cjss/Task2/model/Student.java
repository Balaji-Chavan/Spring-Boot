package com.cjss.Task2.model;

public class Student {
    private String stdId;
    private String stdName;
    private String stdEmail;
    private int year;
    private String branchName;

    public Student(String stdId, String stdName, String stdEmail, int year, String branchName) {
        super();
        this.stdId = stdId;
        this.stdName = stdName;
        this.stdEmail = stdEmail;
        this.year = year;
        this.branchName =branchName;
    }
    public String getStdId() {
        return stdId;
    }
    public void setStdId(String stdId) {
        this.stdId = stdId;
    }
    public String getStdName() {
        return stdName;
    }
    public void setStdName(String stdName) {
        this.stdName = stdName;
    }
    public String getStdEmail() {
        return stdEmail;
    }
    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getBranch() {
        return branchName;
    }
    public void setBranch(String branchName) {
        this.branchName= branchName;
    }


    @Override
    public String toString() {
        return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdEmail=" + stdEmail + ", year=" + year
                + ", Branch=" + branchName + "]";
    }
}
