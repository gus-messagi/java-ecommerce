package com.gusmessagi.ecommercejava.services.api.controllers;

import com.gusmessagi.ecommercejava.modules.application.ProductServiceImpl;
import com.gusmessagi.ecommercejava.modules.domain.dtos.ProductDto;
import com.gusmessagi.ecommercejava.modules.domain.mappers.ProductMapper;
import com.gusmessagi.ecommercejava.modules.domain.repositories.commands.IProductWriteRepository;
import com.gusmessagi.ecommercejava.modules.domain.entities.ProductEntity;
import com.gusmessagi.ecommercejava.services.api.requests.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProductMapper productMapper;

    @GetMapping
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity create(@RequestBody ProductRequest productRequest) {
        ProductDto body = productMapper.toDTO(productRequest);

        return productService.create(body);
    }
}