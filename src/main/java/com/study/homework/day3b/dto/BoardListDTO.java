package com.study.homework.day3b.dto;

import com.study.homework.day3b.domain.Board;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Data
public class BoardListDTO {
    private List<Board> list;
    private int page;
    private int pageSize;
    private long totalCount;
    private String title;
    private String content;

    public PageRequest toPage(){
        int page = 0;
        int pageSize = 0;
        if(this.page > 0 ){
            page = this.page -1;
        }
        if(this.pageSize > 0){
            pageSize = this.pageSize;
        }
        return PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC,"id"));
    }

    public Specification<Board> toSpecification(){
        Specification<Board> title = null;
        Specification<Board> content = null;
        if(this.title != null && !this.title.isEmpty()){
            title = Specification.where((root,query,builder) ->
                    builder.like(root.<String> get("title"), "%" + this.title + "%"));
        }
        if(this.content != null && !this.content.isEmpty()){
            content = Specification.where((root,query,builder) ->
                    builder.like(root.<String> get("content"), "%" + this.content + "%"));
        }
        return Specification.where(title).and(content);
    }
}
