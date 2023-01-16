package com.example.demo.service;

import com.example.demo.controller.response.TeacherResponse;
import com.example.demo.domain.Teacher;
import com.example.demo.mapper.TeacherToTeacherResponseMapper;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListTeachersService {

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private TeacherToTeacherResponseMapper mapper;

    public List<TeacherResponse> list(){
        List<Teacher> list = repository.findAll();
        return list.stream()
                .map(t -> mapper.apply(t))
                .collect(Collectors.toList());
    }

}
