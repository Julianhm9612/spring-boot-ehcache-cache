package com.example.spring_boot_ehcache_cache.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Cacheable(value = "myCache", key = "#id")
    public String getProductById(String id) {
        simulateSlowService();
        return "Product " + id;
    }

    // Simulate a delay to represent a slow database call
    private void simulateSlowService() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @CacheEvict(value = "myCache", key = "#id")
    public void updateProduct(String id, String newProductData) {
        // Update product data in database (omitted)
    }

    @CachePut(value = "myCache", key = "#id")
    public String updateProductInCache(String id, String newProductData) {
        return newProductData; // This updates the cache for the specific product ID
    }
}
