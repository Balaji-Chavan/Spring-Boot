package com.task1.EmployeeTask1.Model;

import java.util.List;

public class Employee {
    private String employeeId;
    private String employeeName;
    private int salary;
    private String locationId;
    private String deptId;
    private List<String> benefitId;


    public Employee(String employeeId, String employeeName, int salary, String locationId, String deptId,
                    List<String> benefitId ) {

        super();
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.locationId = locationId;
        this.deptId = deptId;
        this.benefitId = benefitId;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getLocationId() {
        return locationId;
    }
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
    public String getDeptId() {
        return deptId;
    }
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    public List<String> getBenefitId() {
        return benefitId;
    }
    public void setBenefitId(List<String> benefitId) {
        this.benefitId = benefitId;
    }
    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
                + ", locationId=" + locationId + ", deptId=" + deptId +  ", benefitId=" + benefitId +"]";

    }



}
