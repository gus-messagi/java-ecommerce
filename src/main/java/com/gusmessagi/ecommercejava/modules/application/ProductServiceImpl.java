package com.gusmessagi.ecommercejava.modules.application;

import com.gusmessagi.ecommercejava.modules.domain.dtos.ProductDto;
import com.gusmessagi.ecommercejava.modules.domain.entities.ProductEntity;
import com.gusmessagi.ecommercejava.modules.domain.repositories.commands.IProductWriteRepository;
import com.gusmessagi.ecommercejava.modules.domain.repositories.queries.IProductQueryRepository;
import com.gusmessagi.ecommercejava.modules.domain.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ProductService")
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductQueryRepository productQueryRepository;

    @Autowired
    IProductWriteRepository productWriteRepository;

    @Override
    public List<ProductEntity> findAll() {
        return productQueryRepository.findAll();
    }

    @Override
    public ProductEntity create(ProductDto productDto) {
        ProductEntity productEntity = productDto.toWriteRepository();

        return productWriteRepository.save(productEntity);
    }
}
