package com.example.demo.service;

import com.example.demo.controller.response.VerifyLoginUsageResponse;
import com.example.demo.domain.User;
import com.example.demo.exception.LoginIsBlankException;
import com.example.demo.repository.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerifyLoginUsageService {

    @Autowired
    private UserRepository repository;

    public VerifyLoginUsageResponse verify(String login) {
        if (Strings.isBlank(login))
            throw new LoginIsBlankException();

        boolean unavailable = false;
        Optional<User> user = repository.findByLogin(login);
        if (user.isPresent())
            unavailable = true;

        return new VerifyLoginUsageResponse(unavailable);
    }

}
