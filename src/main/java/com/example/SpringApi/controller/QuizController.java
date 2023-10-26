package com.example.SpringApi.controller;

import com.example.SpringApi.model.Question;
import com.example.SpringApi.model.QuestionWrapper;
import com.example.SpringApi.model.Quiz;
import com.example.SpringApi.model.Response;
import com.example.SpringApi.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    QuizService quizService;



    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {

        return quizService.createQuiz(category ,numQ ,title);
    }


    @GetMapping("getQuestion/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestion(@PathVariable Integer id){

        return quizService.getQuestionById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id,@RequestBody List<Response> responses){

        return quizService.submitAnswer(id,responses);
    }
}
