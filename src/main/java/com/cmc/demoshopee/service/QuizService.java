package com.cmc.demoshopee.service;

import com.cmc.demoshopee.entity.exam.Category;
import com.cmc.demoshopee.entity.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Quiz getQuiz(Integer quizId);
    public void deleteQuiz(Integer quizId);
    public List<Quiz> getQuizzesOfCategory (Category category);
    public List<Quiz> getActiveQuizzes();
    public List<Quiz> getActiveOfCategory(Category c);
}
