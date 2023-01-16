package com.example.demo.service;

import com.example.demo.controller.response.StudentResponse;
import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentToStudentResponseMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListStudentsService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentToStudentResponseMapper mapper;

    public List<StudentResponse> list(){
       List<Student> list = repository.findAll();
       return list.stream()
               .map(s -> mapper.apply(s))
               .collect(Collectors.toList());
    }

}
