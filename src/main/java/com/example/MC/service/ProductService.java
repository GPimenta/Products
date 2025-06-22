package com.example.MC.service;

import com.example.MC.model.ProductDAO;
import com.example.MC.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService{

    @Autowired
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDAO createProduct(ProductDAO product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Optional<ProductDAO> getProduct(String productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public boolean deleteProduct(String productId) {
        return productRepository.deleteByProductId(productId);
    }

    @Override
    public ProductDAO updateProduct(String productId, ProductDAO productDAO) {
        return productRepository.findByProductId(productId)
                .map(productDAO1 -> productRepository.saveAndFlush(productDAO))
                .orElseThrow(() -> new EntityNotFoundException("Product not found with productId: " + productId));
    }
}
