package com.jinternal.product.controllers;

import com.jinternal.product.controllers.requests.ProductRequest;
import com.jinternal.product.domain.Product;
import com.jinternal.product.services.ProductService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/api")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get("/product/{id}")
    public Product getDemoResponse(Long id){
        return productService.getById(id);
    }

    @Post("/product")
    public Product getDemoResponse(@Body ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        return productService.saveProduct(product);
    }

}
