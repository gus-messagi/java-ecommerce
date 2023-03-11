package com.gusmessagi.ecommercejava.modules.domain.entities;

import com.gusmessagi.ecommercejava.modules.domain.entities.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

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
}
