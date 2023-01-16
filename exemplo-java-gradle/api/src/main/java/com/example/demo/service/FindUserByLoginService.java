package com.example.demo.service;

import com.example.demo.controller.response.UserResponse;
import com.example.demo.domain.User;
import com.example.demo.exception.EntryNotFoundException;
import com.example.demo.exception.LoginIsBlankException;
import com.example.demo.mapper.UserToUserResponseMapper;
import com.example.demo.repository.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserByLoginService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserToUserResponseMapper mapper;

    public UserResponse findUserByLogin(String login) {
        if (Strings.isBlank(login))
            throw new LoginIsBlankException();

        Optional<User> user = repository.findByLogin(login);
        return user.map(value -> mapper.apply(value))
            .orElseThrow(() -> {throw new EntryNotFoundException(String.format("Usuário '%s' não encontrado", login));});
    }

}
