package com.example.demo.service;

import com.example.demo.domain.Topic;
import com.example.demo.domain.User;
import com.example.demo.exception.EntryNotFoundException;
import com.example.demo.exception.PermissionDeniedException;
import com.example.demo.repository.TopicRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteTopicByIdService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    public void deleteById(Integer id) {
        String loginUser = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> userOptional = userRepository.findByLogin(loginUser);
        if (userOptional.isEmpty())
            throw new EntryNotFoundException(String.format("O usuário '%s' não pode ser encontrado", loginUser));

        if (!topicRepository.existsById(id))
            throw new EntryNotFoundException(String.format("O tópico de ID '%d' não pode ser encontrado", id));

        Topic topic = topicRepository.getById(id);
        if (!topic.getId().equals(id))
            throw new PermissionDeniedException("O usuário não tem permissão para excluir o tópico");

        topicRepository.deleteById(id);
    }

}
