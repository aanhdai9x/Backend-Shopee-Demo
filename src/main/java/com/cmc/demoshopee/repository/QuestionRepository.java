package com.cmc.demoshopee.repository;

import com.cmc.demoshopee.entity.exam.Question;
import com.cmc.demoshopee.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Set<Question> findByQuiz(Quiz quiz);
}
