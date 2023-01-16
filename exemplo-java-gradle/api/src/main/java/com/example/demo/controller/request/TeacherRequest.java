package com.example.demo.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TeacherRequest {

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

    //Todo: Fix
    //Todo: Fix database too
    @Size(min = 7, max = 7, message = "Não informado com os valores corretos")
    private String Siape;

    //Todo: Review validations

}
