package com.microservice.productservice.service;

import com.microservice.productservice.dto.ProductRequest;
import com.microservice.productservice.dto.ProductResposne;
import com.microservice.productservice.model.Product;
import com.microservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public String createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product with id {} is created", product.getId());
        return product.getId();
    }

    public List<ProductResposne> listAllProducts() {

        return productRepository.findAll().stream()
                .map(product ->
                        new ProductResposne(
                                product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getPrice()))
                .toList();
    }
}
