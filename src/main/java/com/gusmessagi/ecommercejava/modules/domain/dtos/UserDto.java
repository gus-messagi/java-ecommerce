package com.gusmessagi.ecommercejava.modules.domain.dtos;

import com.gusmessagi.ecommercejava.modules.domain.entities.UserEntity;
import com.gusmessagi.ecommercejava.modules.domain.entities.enums.UserType;
import com.gusmessagi.ecommercejava.modules.domain.value_objects.Email;
import com.gusmessagi.ecommercejava.modules.domain.value_objects.Password;

import lombok.Data;

@Data
public class UserDto {
    public String name;
    public Email email;
    public Password password;

    public UserType type;

    public UserDto(String name, Email email, Password password, UserType type) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public UserEntity toWriteRepository() {
        return new UserEntity()
                .setEmail(this.getEmail().getAddress())
                .setPassword(this.getPassword().getHash())
                .setName(this.getName())
                .setType(this.getType());
    }
}
