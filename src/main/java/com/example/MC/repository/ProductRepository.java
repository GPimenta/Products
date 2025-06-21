package com.example.MC.repository;

import com.example.MC.model.Product;
import com.example.MC.model.ProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductDAO, Long> {
    Optional<ProductDAO> findByProductId(String productId);
    Boolean deleteByProductId(String productId);


}
