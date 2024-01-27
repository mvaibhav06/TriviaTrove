package com.quiz.service;

import com.quiz.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionService {

    Question save(Question question);
    List<Question> findAll();
    Question findById(int id);

    void deleteById(int id);


}
