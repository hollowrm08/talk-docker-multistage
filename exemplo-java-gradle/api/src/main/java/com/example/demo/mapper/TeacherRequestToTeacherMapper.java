package com.example.demo.mapper;

import com.example.demo.controller.request.TeacherRequest;
import com.example.demo.domain.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherRequestToTeacherMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Teacher apply(TeacherRequest request) {
        return modelMapper.map(request, Teacher.class);
    }

}
