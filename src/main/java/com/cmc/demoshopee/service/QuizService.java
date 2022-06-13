package com.cmc.demoshopee.service;

import com.cmc.demoshopee.entity.exam.Quiz;
import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Quiz getQuiz(Integer quizId);
    public void deleteQuiz(Integer quizId);
}
