package com.gusmessagi.ecommercejava.modules.domain.value_objects;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

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

    public String getHash() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];

        random.nextBytes(salt);
        
        try{
            KeySpec spec = new PBEKeySpec(this.password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = keyFactory.generateSecret(spec).getEncoded();
            
            Base64.Encoder enc = Base64.getEncoder();

            return enc.encodeToString(hash);
        }catch(NoSuchAlgorithmException | InvalidKeySpecException error) {
            error.printStackTrace();

            return "";
        }
    }
}
