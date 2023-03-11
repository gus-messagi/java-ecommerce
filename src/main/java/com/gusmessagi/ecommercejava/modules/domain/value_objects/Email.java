package com.gusmessagi.ecommercejava.modules.domain.value_objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gusmessagi.ecommercejava.modules.infrastructure.http.exceptions.BadRequestException;

import lombok.Getter;

@Getter
public class Email {
    public String address;
    
    public Email (String address) {
        if (address == null || address.isEmpty()) {
            throw new BadRequestException("E-mail cannot be empty");
        }

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(address);

        if (!matcher.find()) {
            throw new BadRequestException("Invalid E-mail format");
        }

        this.address = address;
    }
}
