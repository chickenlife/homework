package com.study.homework.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoDTO implements Serializable {
    private String userName;
    private int age;
    private int score;
}
