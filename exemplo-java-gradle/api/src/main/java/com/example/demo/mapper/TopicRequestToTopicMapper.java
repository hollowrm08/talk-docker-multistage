package com.example.demo.mapper;

import com.example.demo.controller.request.TopicRequest;
import com.example.demo.domain.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicRequestToTopicMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Topic apply(TopicRequest request) {
        return modelMapper.map(request, Topic.class);
    }

}
