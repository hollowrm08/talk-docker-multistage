package com.example.demo.mapper;

import com.example.demo.controller.response.StudentResponse;
import com.example.demo.domain.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentToStudentResponseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StudentResponse apply(Student domain) {
        return modelMapper.map(domain, StudentResponse.class);
    }

}
