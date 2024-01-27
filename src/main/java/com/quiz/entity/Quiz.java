package com.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quiz_category")
    private String quizCategory;

    @Column(name = "quiz_date")
    private Date quizDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "quiz_questions",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;

    @OneToOne(mappedBy = "quiz")
    @JsonIgnore
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuizCategory() {
        return quizCategory;
    }

    public void setQuizCategory(String quizCategory) {
        this.quizCategory = quizCategory;
    }

    public Date getQuizDate() {
        return quizDate;
    }

    public void setQuizDate(Date quizDate) {
        this.quizDate = quizDate;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Quiz(String quizCategory, Date quizDate, List<Question> questions) {
        this.quizCategory = quizCategory;
        this.quizDate = quizDate;
        this.questions = questions;
    }

    public Quiz(){}

    public Quiz(String quizCategory, Date quizDate) {
        this.quizCategory = quizCategory;
        this.quizDate = quizDate;
    }
}
