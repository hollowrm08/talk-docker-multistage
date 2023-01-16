package com.example.demo.mapper;

import com.example.demo.controller.response.UserResponse;
import com.example.demo.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserResponse apply(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

}
