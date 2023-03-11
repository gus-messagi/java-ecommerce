package com.gusmessagi.ecommercejava.modules.domain.services;

import com.gusmessagi.ecommercejava.modules.domain.dtos.UserDto;
import com.gusmessagi.ecommercejava.modules.domain.entities.UserEntity;

public interface IUserService {
    UserEntity create(UserDto userDto);
}
