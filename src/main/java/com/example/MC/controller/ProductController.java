package com.example.MC.controller;

import com.example.MC.mappers.ProductMapper;
import com.example.MC.model.Product;
import com.example.MC.model.ProductDAO;
import com.example.MC.service.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    ///TODO Need to add @Transation
    @PostMapping
    public ResponseEntity<?> createProduct(Product product, UriComponentsBuilder ucb) {

        Optional<ProductDAO> validateProductDAO = productService
                .getProduct(productService.createProduct(ProductMapper.toProductDAO(product)).getProductId());

        if (validateProductDAO.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ucb.path("/v1/products/{productId}")
                    .buildAndExpand(validateProductDAO.get().getProductId())
                    .toUri();

            return ResponseEntity.ok(uri);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable String productId) {

        Optional<ProductDAO> validateProductDAO = productService.getProduct(productId);

        return validateProductDAO.map(productDAO -> ResponseEntity.ok(ProductMapper.fromProductDAO(validateProductDAO.get())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId) {
        if (productService.deleteProduct(productId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable String productId, @RequestBody Product product) {

        try {
            return ResponseEntity.ok(
                    ProductMapper.fromProductDAO(
                    productService.updateProduct(productId, ProductMapper.toProductDAO(product))));

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }




}
