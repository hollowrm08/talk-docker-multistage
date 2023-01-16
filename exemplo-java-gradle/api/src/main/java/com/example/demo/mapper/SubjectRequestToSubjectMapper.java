package com.example.demo.mapper;

import com.example.demo.controller.request.SubjectRequest;
import com.example.demo.domain.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectRequestToSubjectMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Subject apply(SubjectRequest request) {
        return modelMapper.map(request, Subject.class);
    }

}
