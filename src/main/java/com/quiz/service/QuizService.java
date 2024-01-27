package com.quiz.service;

import com.quiz.entity.Question;
import com.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz save(Quiz quiz);
    Quiz findById(int id);
    List<Quiz> findAll();
    void deleteById(int id);

    Quiz createQuiz(String category);
}
