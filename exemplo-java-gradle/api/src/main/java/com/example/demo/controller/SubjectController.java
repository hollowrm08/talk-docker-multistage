package com.example.demo.controller;

import com.example.demo.controller.request.SubjectRequest;
import com.example.demo.controller.response.SubjectResponse;
import com.example.demo.service.CreateSubjectService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private CreateSubjectService createSubjectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register a new subject")
    public SubjectResponse registerSubject(@RequestBody SubjectRequest request) {
        return createSubjectService.create(request);
    }

}