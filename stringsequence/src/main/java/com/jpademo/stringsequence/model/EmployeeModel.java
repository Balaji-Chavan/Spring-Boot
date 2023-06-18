package com.jpademo.stringsequence.model;

public class EmployeeModel {
    private String id;
    private String name;

    private String salary;

    public EmployeeModel(){
        super();
    }
    public EmployeeModel(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
