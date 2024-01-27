package com.quiz.rest;

import com.quiz.entity.Result;
import com.quiz.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("results")
public class ResultRestController {

    private ResultService resultService;

    @Autowired
    public ResultRestController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public List<Result> findAll(){
        return resultService.findAll();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable int id){
        return resultService.findById(id);
    }

    @PostMapping
    public Result saveResult(@RequestBody Result result){
        return resultService.save(result);
    }
}
