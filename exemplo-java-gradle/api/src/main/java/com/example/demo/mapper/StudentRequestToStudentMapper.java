package com.example.demo.mapper;

import com.example.demo.controller.request.StudentRequest;
import com.example.demo.domain.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentRequestToStudentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Student apply(StudentRequest request){
        return modelMapper.map(request, Student.class);
    }

}
