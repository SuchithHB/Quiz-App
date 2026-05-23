package com.telusko.QuizApp.Dao;

import com.telusko.QuizApp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RAND() LIMIT :noQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int noQ);
}

