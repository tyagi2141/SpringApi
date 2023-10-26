package com.example.SpringApi.service;


import com.example.SpringApi.dao.QuestionDao;
import com.example.SpringApi.dao.QuizDao;
import com.example.SpringApi.model.Question;
import com.example.SpringApi.model.QuestionWrapper;
import com.example.SpringApi.model.Quiz;
import com.example.SpringApi.model.Response;
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

    public ResponseEntity<Quiz> createQuiz(String category, int numQ, String title) {

        List<Question> questionList = questionDao.getRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);
        quizDao.save(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionById(Integer id) {

        Optional<Quiz> dbData = quizDao.findById(id);

        List<Question> dbQuestion = dbData.get().getQuestions();

        List<QuestionWrapper> questionWrapperList = new ArrayList<>();

        for (Question q : dbQuestion) {
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionWrapperList.add(questionWrapper);
        }

        return new ResponseEntity<>(questionWrapperList, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitAnswer(Integer id, List<Response> responses) {

        System.out.println("dfdfdfdf  "+responses.toString());
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questionList = quiz.getQuestions();
        int count = 0;
        int index = 0;
        for (Response r : responses) {
            if (r.response.equals(questionList.get(index).getRightAnswer())) {
                 count++;
            }
            index++;

        }
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
