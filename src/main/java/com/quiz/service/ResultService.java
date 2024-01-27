package com.quiz.service;

import com.quiz.entity.Result;

import java.util.List;

public interface ResultService {

    Result save(Result result);
    Result findById(int id);
    Result findByQuizId(int id);
    List<Result> findAll();
    void deleteById(int id);
}
