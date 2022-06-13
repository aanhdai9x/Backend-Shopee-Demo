package com.cmc.demoshopee.repository;

import com.cmc.demoshopee.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
