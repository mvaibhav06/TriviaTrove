package com.quiz.service;

import com.quiz.dao.ResultDAO;
import com.quiz.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{

    private ResultDAO resultDAO;

    @Autowired
    public ResultServiceImpl(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Override
    public Result save(Result result) {
        return resultDAO.save(result);
    }

    @Override
    public Result findById(int id) {
        return resultDAO.findById(id).orElseThrow(() -> new RuntimeException("Result with given id is not available"));
    }

    @Override
    public Result findByQuizId(int id) {
        return resultDAO.findByQuizId(id);
    }

    @Override
    public List<Result> findAll() {
            return resultDAO.findAll();
    }

    @Override
    public void deleteById(int id) {
        resultDAO.deleteById(id);
    }
}
