package com.ecommerce.productsearch.config;

import com.ecommerce.productsearch.repository.ProductRepository;
import com.ecommerce.productsearch.model.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            if(productRepository.count() == 0){
                productRepository.saveAll(Arrays.asList(
                    new Product(null,"Laptop","Electronics",1200.0),
                    new Product(null,"Smartphone","Electronics",800.0),
                    new Product(null,"Desk Chair","Furniture",150.0)
                ));
            }
        };
    }
}