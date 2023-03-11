package com.gusmessagi.ecommercejava.modules.domain.repositories.commands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gusmessagi.ecommercejava.modules.domain.entities.ProductEntity;

@Repository
public interface IProductWriteRepository extends JpaRepository<ProductEntity, Long> {

}