package com.gusmessagi.ecommercejava.services.api.controllers;

import com.gusmessagi.ecommercejava.modules.application.UserServiceImpl;
import com.gusmessagi.ecommercejava.modules.domain.dtos.UserDto;
import com.gusmessagi.ecommercejava.modules.domain.entities.UserEntity;
import com.gusmessagi.ecommercejava.modules.domain.mappers.UserMapper;
import com.gusmessagi.ecommercejava.modules.infrastructure.http.exceptions.BadRequestException;
import com.gusmessagi.ecommercejava.services.api.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@RequestBody UserRequest userRequest) {
        if (!userRequest.password.equals(userRequest.confirmPassword)) {
            throw new BadRequestException("Passwords doesnt match");
        }

        UserDto body = userMapper.toDTO(userRequest);

        return userService.create(body);
    }
}
