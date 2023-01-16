package com.example.demo.mapper;

import com.example.demo.controller.response.SubjectResponse;
import com.example.demo.domain.Subject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectToSubjectResponseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SubjectResponse apply(Subject domain){
        return modelMapper.map(domain, SubjectResponse.class);
    }

}
