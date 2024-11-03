package com.marlo.asyncProductsApp.controller.controllerExceptions;

// Exception para 500
public class ProductInsertionException extends RuntimeException {
    public ProductInsertionException(String message) {
        super(message);
    }
}