package com.jinternal.product.services;

import com.jinternal.product.domain.Product;
import com.jinternal.product.exceptions.ProductNotFoundException;
import com.jinternal.product.repositories.ProductRepository;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

@Singleton
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(@NotNull Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(String.format("Product with id {id} not found", id)));
    }

    public Product saveProduct(@NotNull Product product) {
        return productRepository.save(product);
    }


}
