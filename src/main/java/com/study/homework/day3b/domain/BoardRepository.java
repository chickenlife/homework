package com.study.homework.day3b.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board,Long>, JpaSpecificationExecutor<Board> {
}
