package com.study.homework.day3b.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Entity
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String content;

    @Column(updatable =false)
    @CreationTimestamp
    private LocalDateTime regDatetime;

    @Column(nullable = false)
    private String regUserId;

    @UpdateTimestamp
    private LocalDateTime editDatetime;

    @Column
    private String editUserId;

    @Builder
    private Board(Long id, String title, String content,
                  String regUserId, String editUserId){
        this.id = id;
        this.title = title;
        this.content = content;
        this.regUserId = regUserId;
        this.editUserId = editUserId;
    }

}
