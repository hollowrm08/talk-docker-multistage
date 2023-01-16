package com.example.demo.service;

import com.example.demo.controller.request.SubjectRequest;
import com.example.demo.controller.response.SubjectResponse;
import com.example.demo.domain.Subject;
import com.example.demo.mapper.SubjectRequestToSubjectMapper;
import com.example.demo.mapper.SubjectToSubjectResponseMapper;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSubjectService {

    @Autowired
    private SubjectRequestToSubjectMapper requestMapper;

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private SubjectToSubjectResponseMapper responseMapper;

    public SubjectResponse create(SubjectRequest request) {
        Subject subject = requestMapper.apply(request);
        subject = repository.save(subject);

        return responseMapper.apply(subject);
    }

}
