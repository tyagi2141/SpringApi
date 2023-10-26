package com.example.SpringApi.controller;

import com.example.SpringApi.model.Question;
import com.example.SpringApi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String home() {

        return "Hi i am Running";
    }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestion() {
        return questionService.getAllService();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("save")
    public Question insertQuestion(@RequestBody Question question) {
        System.out.println("resultQuestion :  " + question);
        return questionService.saveQuestion(question);
    }

    @GetMapping("/getByCategory/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category) {
        System.out.println("hhhghjhjg   : " + category);
        return questionService.getByCategory(category);
    }
}
