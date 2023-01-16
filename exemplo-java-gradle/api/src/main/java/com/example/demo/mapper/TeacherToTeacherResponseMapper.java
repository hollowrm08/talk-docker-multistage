package com.example.demo.mapper;

import com.example.demo.controller.response.TeacherResponse;
import com.example.demo.domain.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherToTeacherResponseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TeacherResponse apply(Teacher domain){
        return modelMapper.map(domain, TeacherResponse.class);
    }

}
