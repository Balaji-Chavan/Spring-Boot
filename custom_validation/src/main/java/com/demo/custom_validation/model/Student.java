package com.demo.custom_validation.model;

import com.demo.custom_validation.Validation.AgeValidate;
import com.demo.custom_validation.Validation.BranchValidate;
import com.demo.custom_validation.Validation.PhoneValidate;
import com.demo.custom_validation.Validation.YearValidate;

import javax.validation.constraints.*;

public class Student {
    @NotBlank
    @Pattern(regexp = "^[st]{2}\\d+")
    private String id;
    @NotEmpty
    @Size(min = 3,message = "name contains atleast 3 char")
    private String name;
    @NotNull
    @Email
    private String email;
    @NotEmpty
    @PhoneValidate
    private String  mobNo;

    @NotEmpty
    @BranchValidate
    private String  branch;

@AgeValidate
    private int age;

@YearValidate
    private int year;


    public Student(String id, String name, String email, String mobNo, String branch, int age, int year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobNo = mobNo;
        this.branch = branch;
        this.age = age;
        this.year = year;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
