package com.gusmessagi.ecommercejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.gusmessagi.ecommercejava.modules.domain.entities"})
public class EcommerceJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceJavaApplication.class, args);
	}

}
