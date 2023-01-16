package com.example.demo.controller.request;

import com.example.demo.domain.Privacy;
import com.example.demo.domain.TypeAuthor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class TopicRequest {

    @NotEmpty
    private String content;

    @NotEmpty
    private Privacy privacy;

    @NotEmpty
    private TypeAuthor typeAuthor;

    private String pathImage;

    @NotEmpty
    private String subjectAbbreviation;
    //Todo: Confirm


}
