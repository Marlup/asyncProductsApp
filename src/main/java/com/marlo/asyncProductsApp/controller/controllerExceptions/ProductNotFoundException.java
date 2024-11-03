package com.marlo.asyncProductsApp.controller.controllerExceptions;

// Exception para 404
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
