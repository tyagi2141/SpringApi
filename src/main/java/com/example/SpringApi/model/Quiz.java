package com.example.SpringApi.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String title;

    @ManyToMany
    List<Question> questions;
}
