package com.quiz.service;

import com.quiz.dao.QuestionDAO;
import com.quiz.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionDAO questionDAO;

    @Autowired
    public QuestionServiceImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    public Question save(Question question) {
        return questionDAO.save(question);
    }

    @Override
    public List<Question> findAll() {
        return questionDAO.findAll();
    }

    @Override
    public Question findById(int id) {
        return questionDAO.findById(id).orElseThrow(() -> new RuntimeException("Question with given id not found!"));
    }

    @Override
    public void deleteById(int id) {
        questionDAO.deleteById(id);
    }
}
