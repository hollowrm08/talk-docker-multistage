package com.example.demo.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SubjectRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String abbreviation;

}