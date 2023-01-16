package com.example.demo.controller;

import com.example.demo.controller.response.UserResponse;
import com.example.demo.service.DeleteByLoginService;
import com.example.demo.service.FindUserByLoginService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FindUserByLoginService findUserByLoginService;

    @Autowired
    private DeleteByLoginService deleteByLoginService;

    @GetMapping("{login}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find a user by login")
    public UserResponse findUserByLogin(@PathVariable String login) {
        return findUserByLoginService.findUserByLogin(login);
    }

    @DeleteMapping("{login}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a user by login")
    public void deleteByLogin(@PathVariable String login) {
        deleteByLoginService.deleteUser(login);
    }

}
