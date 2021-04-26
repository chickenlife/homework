package com.study.homework.day3d.repository;

import com.study.homework.day3d.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    //custom methods 생략
}
