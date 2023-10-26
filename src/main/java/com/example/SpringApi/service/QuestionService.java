package com.example.SpringApi.service;


import com.example.SpringApi.dao.QuestionDao;
import com.example.SpringApi.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllService() {
        return questionDao.findAll();
    }

    public Question saveQuestion(Question question) {
        return questionDao.save(question);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {


        try {
            return new ResponseEntity<>(questionDao.getByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);

    }
}
