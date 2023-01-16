package com.example.demo.mapper;

import com.example.demo.controller.response.TopicResponse;
import com.example.demo.domain.Topic;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicToTopicResponseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TopicResponse apply(Topic topic) {
        return modelMapper.map(topic, TopicResponse.class);
    }

}
