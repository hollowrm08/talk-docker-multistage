package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.exception.EntryNotFoundException;
import com.example.demo.exception.LoginIsBlankException;
import com.example.demo.repository.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteByLoginService {

    @Autowired
    private UserRepository userRepository;

    public void deleteUser(String login) {
        if (Strings.isBlank(login))
            throw new LoginIsBlankException();

        Optional<User> user = userRepository.findByLogin(login);
        user.ifPresentOrElse(value -> userRepository.delete(value), () -> {
            throw new EntryNotFoundException(String.format("Usuário '%s' não encontrado", login));
        });
    }

}
