package com.marlo.asyncProductsApp.controller;

import com.marlo.asyncProductsApp.repository.entity.ProductEntity;
import com.marlo.asyncProductsApp.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private ServiceImpl demoService;

    @GetMapping("/products")
    public CompletableFuture<ResponseEntity<?>> getAllProducts() {
        return demoService.getAllProducts().thenApply(ResponseEntity::ok);
        /*
        try {
            return ResponseEntity.ok(demoService.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        */
    }

    @PostMapping("/product")
    public CompletableFuture<?> addProduct(@RequestBody List<ProductEntity> productList) {
        return demoService.save(productList).thenApply(ResponseEntity::ok);
    }
}
