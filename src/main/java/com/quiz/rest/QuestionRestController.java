package com.quiz.rest;

import com.quiz.dao.QuestionDAO;
import com.quiz.entity.Question;
import com.quiz.service.QuestionService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionRestController {

    private QuestionService questionService;

    @Autowired
    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> findAll(){
        return questionService.findAll();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable int id){
        return questionService.findById(id);
    }

    @PostMapping
    public Question addQuestion(@RequestBody Question question){
        return questionService.save(question);
    }

    @PutMapping
    public Question updateQuestion(@RequestBody Question question){
        return questionService.save(question);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable int id){
        questionService.deleteById(id);
        return "Success";
    }


}
