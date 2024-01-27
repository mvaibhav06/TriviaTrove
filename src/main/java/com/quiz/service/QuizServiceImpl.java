package com.quiz.service;

import com.quiz.dao.QuestionDAO;
import com.quiz.dao.QuizDAO;
import com.quiz.entity.Question;
import com.quiz.entity.Quiz;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private QuizDAO quizDAO;
    private QuestionDAO questionDAO;

    @Autowired
    public QuizServiceImpl(QuizDAO quizDAO, QuestionDAO questionDAO) {
        this.quizDAO = quizDAO;
        this.questionDAO = questionDAO;
    }

    @Override
    @Transactional
    public Quiz save(Quiz quiz) {
        return quizDAO.save(quiz);
    }

    @Override
    public Quiz findById(int id) {
        return quizDAO.findById(id).orElseThrow(() -> new RuntimeException("Quiz with given id not found"));
    }

    @Override
    public List<Quiz> findAll() {
        return quizDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        quizDAO.deleteById(id);
    }

    @Override
    public Quiz createQuiz(String category) {

        if (category.equals("java")){
            category = "Java Programming";
        } else if (category.equals("string")) {
            category = "String Handling";
        }else if (category.equals("gk")){
            category = "Current Affairs";
        }else {
            category = "Python Programming";
        }

        List<Question> questions = questionDAO.findByCategory(category);
        Date date = new Date();
        Quiz quiz = new Quiz(category, date, questions);
        return quizDAO.save(quiz);
    }


}
