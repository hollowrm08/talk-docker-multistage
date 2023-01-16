package com.example.demo.service;

import com.example.demo.controller.response.SubjectResponse;
import com.example.demo.domain.Subject;
import com.example.demo.mapper.SubjectToSubjectResponseMapper;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListSubjectsService {

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private SubjectToSubjectResponseMapper mapper;

    public List<SubjectResponse> listSubjects(){
        List<Subject> list = repository.findAll();
        return list.stream()
                .map(s -> mapper.apply(s))
                .collect(Collectors.toList());
    }

}
