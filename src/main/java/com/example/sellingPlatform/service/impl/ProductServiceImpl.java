package com.example.sellingPlatform.service.impl;

import com.example.sellingPlatform.model.Product;
import com.example.sellingPlatform.repository.ProductRepository;
import com.example.sellingPlatform.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product p) {
        return productRepository.save(p);
    }
}
