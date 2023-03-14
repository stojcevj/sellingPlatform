package com.example.sellingPlatform.service;

import com.example.sellingPlatform.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAll();
    Product save(Product p);
}
