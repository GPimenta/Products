package com.example.MC.mappers;

import com.example.MC.model.Product;
import com.example.MC.model.ProductDAO;

//TODO Check Spring Mapper
public class ProductMapper {
    public static ProductDAO toProductDAO(Product product) {
        ProductDAO productDAO = new ProductDAO();

        productDAO.setProductId(product.getProductId());
        productDAO.setName(product.getName());
        productDAO.setPrice(product.getPrice());
        productDAO.setInventory(product.getInventory());
        productDAO.setBrand(product.getBrand());

        return productDAO;
    }

    public static Product fromProductDAO(ProductDAO productDAO) {
        Product product = new Product();

        product.setProductId(productDAO.getProductId());
        product.setName(productDAO.getName());
        product.setPrice(productDAO.getPrice());
        product.setInventory(productDAO.getInventory());
        product.setBrand(productDAO.getBrand());

        return product;
    }
}
