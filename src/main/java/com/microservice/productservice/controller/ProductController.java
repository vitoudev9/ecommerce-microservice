package com.microservice.productservice.controller;

import com.microservice.productservice.dto.ProductRequest;
import com.microservice.productservice.dto.ProductResposne;
import com.microservice.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
//@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService; // Need manual constructor
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResposne> listAllProducts() {
        return productService.listAllProducts();
    }
}
