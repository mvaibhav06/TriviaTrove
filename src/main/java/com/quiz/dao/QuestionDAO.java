package com.quiz.dao;

import com.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
}
