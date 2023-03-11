package com.gusmessagi.ecommercejava.modules.application;

import com.gusmessagi.ecommercejava.modules.domain.dtos.UserDto;
import com.gusmessagi.ecommercejava.modules.domain.entities.UserEntity;
import com.gusmessagi.ecommercejava.modules.domain.repositories.commands.IUserWriteRepository;
import com.gusmessagi.ecommercejava.modules.domain.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserWriteRepository userWriteRepository;

    @Override
    public UserEntity create(UserDto userDto) {
        UserEntity userEntity = userDto.toWriteRepository();

        return userWriteRepository.save(userEntity);
    }
}
