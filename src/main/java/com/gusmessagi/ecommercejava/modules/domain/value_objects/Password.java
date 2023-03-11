package com.gusmessagi.ecommercejava.modules.domain.value_objects;


import com.gusmessagi.ecommercejava.modules.infrastructure.http.exceptions.BadRequestException;

public class Password {
    public String password;

    public Password(String password) {
        if (password == null || password.isEmpty()) {
            throw new BadRequestException("Password cannot be empty");
        }

        if (password.length() < 6) {
            throw new BadRequestException("Password must have at least 6 digits");
        }

        this.password = password;
    }

    public String getValue() {
        return this.password;
    }
}
