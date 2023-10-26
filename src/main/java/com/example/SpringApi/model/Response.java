package com.example.SpringApi.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Response {
    public Integer id;
    public String response;
}
