package com.telusko.QuizApp.Service;

import com.telusko.QuizApp.DTO.ResponseDTO;
import com.telusko.QuizApp.DTO.questionDTO;
import com.telusko.QuizApp.Dao.QuestionDao;
import com.telusko.QuizApp.Dao.QuizDao;
import com.telusko.QuizApp.Entity.Question;
import com.telusko.QuizApp.Entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public String createQuiz(String category, int noQ, String title){
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, noQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return "Success";
    }


    public List<questionDTO> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz =quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<questionDTO> questionsForUser = new ArrayList<>();
        for (Question q : questionsFromDB) {
            questionDTO qw = new questionDTO(q.getId(),q.getCategory(),q.getDifficultyLevel(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
        return questionsForUser;
    }

    public Integer calculateResult(Integer id, List<ResponseDTO> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i=0;
        for(ResponseDTO response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
                right++;

            }
            i++;
        }
        return right;
    }
}
