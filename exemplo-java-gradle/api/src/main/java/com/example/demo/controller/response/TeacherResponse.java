package com.example.demo.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TeacherResponse {

    private String name;

    private String login;

    private String email;

    private String bio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    private String siape;

}
