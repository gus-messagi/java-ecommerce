package com.gusmessagi.ecommercejava.modules.domain.mappers;

import com.gusmessagi.ecommercejava.modules.domain.dtos.UserDto;
import com.gusmessagi.ecommercejava.modules.domain.entities.enums.UserType;
import com.gusmessagi.ecommercejava.modules.domain.value_objects.Email;
import com.gusmessagi.ecommercejava.modules.domain.value_objects.Password;
import com.gusmessagi.ecommercejava.services.api.requests.UserRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class UserMapper {
    public UserDto toDTO(UserRequest userRequest) {
        Email userRequestEmail = new Email(userRequest.email);
        Password userRequestPassword = new Password(userRequest.password);

        return new UserDto(userRequest.name, userRequestEmail, userRequestPassword, UserType.BASIC);
    }
}
