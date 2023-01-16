package com.example.demo.service;

import com.example.demo.controller.request.StudentRequest;
import com.example.demo.controller.response.StudentResponse;
import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentRequestToStudentMapper;
import com.example.demo.mapper.StudentToStudentResponseMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterStudentService {

    @Autowired
    private StudentRequestToStudentMapper requestMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentToStudentResponseMapper responseMapper;

    public StudentResponse register(StudentRequest request) {
        Student studentDomain = requestMapper.apply(request);
        studentDomain.setPassword(encoder.encode(studentDomain.getPassword()));

        studentDomain = repository.save(studentDomain);
        return responseMapper.apply(studentDomain);
    }

}
