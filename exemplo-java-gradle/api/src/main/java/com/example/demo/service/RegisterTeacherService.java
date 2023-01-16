package com.example.demo.service;

import com.example.demo.controller.request.TeacherRequest;
import com.example.demo.controller.response.TeacherResponse;
import com.example.demo.domain.Teacher;
import com.example.demo.mapper.TeacherRequestToTeacherMapper;
import com.example.demo.mapper.TeacherToTeacherResponseMapper;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterTeacherService {

    @Autowired
    private TeacherRequestToTeacherMapper requestMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private TeacherToTeacherResponseMapper responseMapper;

    public TeacherResponse register(TeacherRequest request){
        Teacher teacherDomain = requestMapper.apply(request);
        teacherDomain.setPassword(encoder.encode(teacherDomain.getPassword()));

        teacherDomain = repository.save(teacherDomain);
        return responseMapper.apply(teacherDomain);
    }

}
