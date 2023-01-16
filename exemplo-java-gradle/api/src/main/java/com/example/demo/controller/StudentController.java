package com.example.demo.controller;

import com.example.demo.controller.response.StudentResponse;
import com.example.demo.service.ListStudentsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ListStudentsService listStudentsService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List all enrolled students")
    public List<StudentResponse> listStudents() {
        return listStudentsService.list();
    }

}
