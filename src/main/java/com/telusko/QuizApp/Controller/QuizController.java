package com.telusko.QuizApp.Controller;

import com.telusko.QuizApp.DTO.ResponseDTO;
import com.telusko.QuizApp.DTO.questionDTO;
import com.telusko.QuizApp.Entity.Question;
import com.telusko.QuizApp.Entity.Quiz;
import com.telusko.QuizApp.Service.QuestionService;
import com.telusko.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noQ, @RequestParam String title){

        try{
            return new ResponseEntity<>(quizService.createQuiz(category, noQ, title), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Quiz Creation Failed", HttpStatus.OK);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<questionDTO>> getQuizQuestions(@PathVariable Integer id){
        try{
        return new ResponseEntity<>(quizService.getQuizQuestions(id),HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<questionDTO>(),HttpStatus.OK);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<ResponseDTO> responses){
        try{
            return new ResponseEntity<>(quizService.calculateResult(id, responses), HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
