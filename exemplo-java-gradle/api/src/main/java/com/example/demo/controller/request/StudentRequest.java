package com.example.demo.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String login;

    @Email
    private String email;

    @NotEmpty
    private String password;

    private String bio = "Hello world!";

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthday;

    @NotEmpty
    private String enrollment;

    //Todo: Review validations

}
