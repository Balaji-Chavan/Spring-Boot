package com.jpa.crud.JpaCrudDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentModel {
    private int id;
    private String name;

    private String email;
    private String branch;

    private String  mob_no;

}
