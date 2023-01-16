package com.example.demo.controller.response;

import com.example.demo.domain.Privacy;
import com.example.demo.domain.TypeAuthor;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopicResponse {

    private Integer id;

    private String content;

    private Privacy privacy;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime dateOfCreation;

    private TypeAuthor typeAuthor;

    private String pathImage;

    private SubjectResponse subject;

    private UserResponse author;

}
