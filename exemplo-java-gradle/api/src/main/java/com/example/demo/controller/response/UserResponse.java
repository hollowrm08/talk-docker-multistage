package com.example.demo.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {

    private String name;

    private String login;

    private String email;

    private String bio;

    private LocalDate birthday;

}
