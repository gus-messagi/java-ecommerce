package com.gusmessagi.ecommercejava.modules.domain.repositories.commands;

import com.gusmessagi.ecommercejava.modules.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserWriteRepository extends JpaRepository<UserEntity, Long> {
}
