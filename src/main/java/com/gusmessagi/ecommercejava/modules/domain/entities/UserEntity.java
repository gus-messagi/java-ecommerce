package com.gusmessagi.ecommercejava.modules.domain.entities;

import com.gusmessagi.ecommercejava.modules.domain.entities.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Data
@Entity(name = "Users")
@EnableAutoConfiguration
@NoArgsConstructor
@Accessors(chain = true)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "default 'BASIC'")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @PrePersist
    public void hashPassword() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];

        random.nextBytes(salt);
        
        try{
            KeySpec spec = new PBEKeySpec(this.password.toCharArray(), salt, 65536, 128);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = keyFactory.generateSecret(spec).getEncoded();
            
            Base64.Encoder enc = Base64.getEncoder();

            this.setPassword(enc.encodeToString(hash));
        }catch(NoSuchAlgorithmException | InvalidKeySpecException error) {
            error.printStackTrace();
        }
    }
}
