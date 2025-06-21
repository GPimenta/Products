package com.example.MC.service;

import com.example.MC.model.Product;
import com.example.MC.model.ProductDAO;

import java.util.Optional;

public interface IProductService {

    ProductDAO createProduct(ProductDAO product);
    Optional<ProductDAO> getProduct(String productId);
    boolean deleteProduct(String productId);
    ProductDAO updateProduct(String productId, ProductDAO productDAO);

}