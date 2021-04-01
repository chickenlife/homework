package com.study.homework.day2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonGradeDto implements Serializable {
    private String userName;
    private int age;
    private int grade;
}
