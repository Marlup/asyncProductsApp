package com.marlo.asyncProductsApp.service;

import com.marlo.asyncProductsApp.repository.entity.ProductEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface DemoService {
    CompletableFuture<List<ProductEntity>> getAllProducts();
    CompletableFuture<List<ProductEntity>> save(List<ProductEntity> products);
}
