package com.ecommerce.productsearch.controller;
import com.ecommerce.productsearch.repository.ProductRepository;
import com.ecommerce.productsearch.model.Product;
import com.ecommerce.productsearch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository = null;

    // a. /products/category/{category} (Using derived query)
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }

    // b. /products/filter?min=&max= (Using derived query)
    @GetMapping("/filter")
    public List<Product> filterProductsByPrice(@RequestParam double min, @RequestParam double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    // c. /products/sorted (Using JPQL)
    @GetMapping("/sorted")
    public List<Product> getProductsSorted() {
        return productRepository.findAllSortedByPrice();
    }

    // d. /products/expensive/{price} (Using JPQL)
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return productRepository.findProductsAbovePrice(price);
    }

    // Additional endpoint for JPQL category search as requested in task 3.c
    @GetMapping("/category-jpql/{category}")
    public List<Product> getProductsByCategoryJPQL(@PathVariable String category) {
        return productRepository.getProductsByCategoryJPQL(category);
    }
}
