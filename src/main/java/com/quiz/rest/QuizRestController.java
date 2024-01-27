package com.quiz.rest;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizRestController {

    private QuizService quizService;

    @Autowired
    public QuizRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{category}")
    public Quiz createQuiz(@PathVariable String category){
        return quizService.createQuiz(category);
    }
}
