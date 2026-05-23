package com.telusko.QuizApp.Controller;

import com.telusko.QuizApp.Entity.Question;
import com.telusko.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/AllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/PostQuestion")
    public ResponseEntity<List<Question>> postQuestion(@RequestBody List<Question> questions){
        try{
        return new ResponseEntity<>(questionService.postQuestion(questions), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>(),
                HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        try{
            return new ResponseEntity<>(questionService.getQuestionByCategory(category), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        try {
            questionService.deleteQuestion(id);
            return new ResponseEntity<>("Question deleted Successfully",HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());

        }
        return new ResponseEntity<>("Question cannot be deleted",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @PutMapping("/Update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        try{
        return new ResponseEntity<>(questionService.updateQuestion(question), HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(new Question(),HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
