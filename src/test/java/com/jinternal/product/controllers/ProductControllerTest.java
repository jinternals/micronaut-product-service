package com.jinternal.product.controllers;

import com.jinternal.product.controllers.requests.ProductRequest;
import com.jinternal.product.domain.Product;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;

import javax.inject.Inject;

import static io.micronaut.http.HttpRequest.POST;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class ProductControllerTest {

    @Inject
    @Client("/")
    private HttpClient client;


    @Test
    void saveProduct() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Tata Tea");
        Product product = client.toBlocking().retrieve(POST("/api/product", productRequest), Product.class);
        assertEquals("Tata Tea", product.getName());
    }

}
