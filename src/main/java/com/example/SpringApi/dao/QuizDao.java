package com.example.SpringApi.dao;

import com.example.SpringApi.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
