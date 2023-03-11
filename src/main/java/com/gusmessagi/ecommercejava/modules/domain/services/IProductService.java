package com.gusmessagi.ecommercejava.modules.domain.services;

import com.gusmessagi.ecommercejava.modules.domain.dtos.ProductDto;
import com.gusmessagi.ecommercejava.modules.domain.entities.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductEntity> findAll();
    ProductEntity create(ProductDto productDto);
}
