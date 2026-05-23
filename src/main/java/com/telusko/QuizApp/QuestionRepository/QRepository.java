package com.telusko.QuizApp.QuestionRepository;

import com.telusko.QuizApp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRepository extends JpaRepository<Question, Integer> {
}
