package com.gusmessagi.ecommercejava.modules.domain.repositories.queries;

import com.gusmessagi.ecommercejava.modules.domain.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductQueryRepository extends JpaRepository<ProductEntity, Long> {
}
