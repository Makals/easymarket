package com.mstoppa.service;

import com.mstoppa.model.Product;
import com.mstoppa.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Long id) {
        return productRepository.findOne(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
