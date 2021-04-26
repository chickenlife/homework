package com.study.homework.day3c.domain;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue
    int id;
    String email;
    String password;
}
