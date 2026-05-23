package com.telusko.QuizApp.Service;

import com.telusko.QuizApp.Dao.QuestionDao;
import com.telusko.QuizApp.Entity.Question;
import com.telusko.QuizApp.QuestionRepository.QRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {


    @Autowired
    QuestionDao repo;

    public List<Question> getQuestionByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Question> getAllQuestions() {
       return repo.findAll();
    }

    public List<Question> postQuestion(List<Question> questions) {
        return repo.saveAll(questions);
    }

    public void deleteQuestion(int id) {
        repo.deleteById(id);
    }

    public Question updateQuestion(Question question) {
        return repo.save(question);
    }


}
