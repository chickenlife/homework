package com.study.homework.day3.service;

import com.study.homework.day3.domain.Posts;
import com.study.homework.day3.domain.PostsRepository;
import com.study.homework.day3.dto.PostsResponseDto;
import com.study.homework.day3.dto.PostsSaveRequestDto;
import com.study.homework.day3.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id,PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("nothing"));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("nothing"));
        return new PostsResponseDto(entity);
    }
}
