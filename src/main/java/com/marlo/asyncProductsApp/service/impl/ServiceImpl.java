package com.marlo.asyncProductsApp.service.impl;

import com.marlo.asyncProductsApp.repository.ProductRepository;
import com.marlo.asyncProductsApp.repository.entity.ProductEntity;
import com.marlo.asyncProductsApp.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ServiceImpl implements DemoService {

    @Autowired
    private ProductRepository productRepository;

    @Async
    @Override
    public CompletableFuture<List<ProductEntity>> getAllProducts() {
        long startTime = System.currentTimeMillis();

        List<ProductEntity> products = productRepository.findAll();

        long endTime = System.currentTimeMillis();

        log.info("Total time: " + (endTime - startTime));
        return CompletableFuture.completedFuture(products);
    }

    @Async
    @Override
    public CompletableFuture<List<ProductEntity>> save(List<ProductEntity> products) {
        long startTime = System.currentTimeMillis();

        List<ProductEntity> reportedProducts = productRepository.saveAll(products);

        long endTime = System.currentTimeMillis();

        log.info("Total time: " + (endTime - startTime));
        return CompletableFuture.completedFuture(reportedProducts);
    }
}
