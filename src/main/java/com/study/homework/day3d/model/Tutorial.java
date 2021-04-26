package com.study.homework.day3d.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
@Data
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column
    private String description;

    @Column
    private boolean published;

    //예제의 기본 세팅들은 @Data로 처리
}
