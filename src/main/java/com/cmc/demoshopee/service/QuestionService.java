package com.cmc.demoshopee.service;

import com.cmc.demoshopee.entity.exam.Question;
import com.cmc.demoshopee.entity.exam.Quiz;
import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Integer questionId);
    public Set<Question> getQuestionOfQuiz(Quiz quiz);
    public void deleteQuestion(int quesId);

}
