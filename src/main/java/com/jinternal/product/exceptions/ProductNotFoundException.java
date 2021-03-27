package com.jinternal.product.exceptions;

import io.micronaut.http.exceptions.HttpStatusException;

import static io.micronaut.http.HttpStatus.NOT_FOUND;

public class ProductNotFoundException extends HttpStatusException {
    public ProductNotFoundException(String message) {
        super(NOT_FOUND, message);
    }
}
