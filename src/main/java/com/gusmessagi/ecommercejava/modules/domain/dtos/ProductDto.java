package com.gusmessagi.ecommercejava.modules.domain.dtos;

import com.gusmessagi.ecommercejava.modules.domain.entities.ProductEntity;
import lombok.Data;

@Data
public class ProductDto {
    public String name;
    public String image;
    public Float price;

    public ProductDto(String image, String name, float price) {
      this.image = image;
      this.name = name;
      this.price = price;
    }

    public ProductEntity toWriteRepository() {
        return new ProductEntity()
                .setName(this.getName())
                .setImage(this.getImage())
                .setPrice(this.getPrice());
    }
}
