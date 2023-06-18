package com.jpademo.stringsequence.entity;

import com.jpademo.stringsequence.StringPrfixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @GenericGenerator(name="employee_seq",
    strategy = "com.jpademo.stringsequence.StringPrfixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name= StringPrfixedSequenceIdGenerator.INCREMENT_PARAM,value="2"),
                    @Parameter(name= StringPrfixedSequenceIdGenerator.Value_Prefix_Parameter,value="emp_"),
                    @Parameter(name= StringPrfixedSequenceIdGenerator.Number_Format_Parameter,value="%05d")
    })
    private String id;
    private String name;

    private String salary;

    public Employee(){
        super();
    }
    public Employee(String id, String name, String salary) {
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
