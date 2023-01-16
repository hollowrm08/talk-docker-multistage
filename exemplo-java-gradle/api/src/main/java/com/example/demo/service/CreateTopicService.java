package com.example.demo.service;

import com.example.demo.controller.request.TopicRequest;
import com.example.demo.controller.response.TopicResponse;
import com.example.demo.domain.Subject;
import com.example.demo.domain.Topic;
import com.example.demo.domain.User;
import com.example.demo.exception.EntryNotFoundException;
import com.example.demo.mapper.TopicRequestToTopicMapper;
import com.example.demo.mapper.TopicToTopicResponseMapper;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.repository.TopicRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class CreateTopicService {

    @Autowired
    private TopicRequestToTopicMapper requestMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicToTopicResponseMapper responseMapper;

    public TopicResponse createTopic(TopicRequest request) {
        Topic topic = requestMapper.apply(request);

        Optional<Subject> subjectOptional = subjectRepository.findByAbbreviation(request.getSubjectAbbreviation());
        if (subjectOptional.isEmpty())
            throw new EntryNotFoundException(String.format("A matéria '%s' não pode ser encontrada", request.getSubjectAbbreviation()));

        topic.setSubject(subjectOptional.get());

        String loginUser = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> userOptional = userRepository.findByLogin(loginUser);
        if (userOptional.isEmpty())
            throw new EntryNotFoundException(String.format("O usuário '%s' não pode ser encontrado", loginUser));

        topic.setAuthor(userOptional.get());
        topic.setDateOfCreation(LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))); //Todo: fix

        topic = topicRepository.save(topic);
        return responseMapper.apply(topic);
    }


}
