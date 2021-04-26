package com.study.homework.day3b.dto;

import com.study.homework.day3b.domain.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardDTO {
    private long id;
    private String title;
    private String content;
    private LocalDateTime regDatetime;
    private String regUserId;
    private LocalDateTime editDatetime;
    private String editUserId;

    public Board toEntity(){
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .regUserId(regUserId)
                .editUserId(editUserId)
                .build();
    }

    public BoardDTO(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.regDatetime = board.getRegDatetime();
        this.regUserId = board.getRegUserId();
        this.editDatetime = board.getEditDatetime();
        this.editUserId = board.getEditUserId();
    }
}

