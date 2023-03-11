package com.gusmessagi.ecommercejava.modules.domain.mappers;

import com.gusmessagi.ecommercejava.modules.domain.dtos.ProductDto;
import com.gusmessagi.ecommercejava.services.api.requests.ProductRequest;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class ProductMapper {
    public ProductDto toDTO(ProductRequest request) {
        return new ProductDto(request.image, request.name, request.price);
    }
}
