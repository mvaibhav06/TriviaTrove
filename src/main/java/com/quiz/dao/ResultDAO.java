package com.quiz.dao;

import com.quiz.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultDAO extends JpaRepository<Result, Integer> {
    Result findByQuizId(int id);
}
