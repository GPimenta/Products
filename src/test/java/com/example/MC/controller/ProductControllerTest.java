package com.example.MC.controller;

import com.example.MC.model.Product;
import com.example.MC.model.ProductDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getProduct() {
        Product product = new Product();
        product.setProductId("aabb-0001");
        product.setName("Switch 2");
        product.setPrice(new BigDecimal("500.23"));
        product.setInventory(20);
        product.setBrand("Nintendo");

        ResponseEntity<Void> postResponseEntity = restTemplate.postForEntity("/v1/products", product, Void.class);
        assertThat(postResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ResponseEntity<Product> response = restTemplate.getForEntity("/v1/products/aabb-0001", Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getProductId()).isEqualTo("aabb-0001");
        assertThat(response.getBody().getName()).isEqualTo("Switch 2");
        assertThat(response.getBody().getPrice()).isEqualTo("500.23");
        assertThat(response.getBody().getInventory()).isEqualTo(20);
        assertThat(response.getBody().getBrand()).isEqualTo("Nintendo");
    }

    @Test
    public void createProduct() {
        Product product1 = new Product();
        product1.setProductId("bbaa-0001");
        product1.setName("Playstation 5");
        product1.setPrice(new BigDecimal("200.12"));
        product1.setInventory(1);
        product1.setBrand("Sony");

        Product product2 = new Product();
        product2.setProductId("bbaa-0002");
        product2.setName("Playstation 5 Pro");
        product2.setPrice(new BigDecimal("300.12"));
        product2.setInventory(100);
        product2.setBrand("Sony");

        ResponseEntity<Void> response1 = restTemplate.postForEntity("/v1/products", product1, Void.class);
        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ResponseEntity<Void> response2 = restTemplate.postForEntity("/v1/products", product2, Void.class);
        assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        ResponseEntity<Product> getResponse1 =  restTemplate.getForEntity("/v1/products/bbaa-0001", Product.class);
        ResponseEntity<Product> getResponse2 =  restTemplate.getForEntity("/v1/products/bbaa-0002", Product.class);

        assertThat(getResponse1.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse1.getBody()).isNotNull();
        assertThat(getResponse1.getBody().getProductId()).isEqualTo("bbaa-0001");
        assertThat(getResponse1.getBody().getName()).isEqualTo("Playstation 5");
        assertThat(getResponse1.getBody().getPrice()).isEqualTo("200.12");
        assertThat(getResponse1.getBody().getInventory()).isEqualTo(1);
        assertThat(getResponse1.getBody().getBrand()).isEqualTo("Sony");

        assertThat(getResponse2.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse2.getBody()).isNotNull();
        assertThat(getResponse2.getBody().getProductId()).isEqualTo("bbaa-0002");
        assertThat(getResponse2.getBody().getName()).isEqualTo("Playstation 5 Pro");
        assertThat(getResponse2.getBody().getPrice()).isEqualTo("300.12");
        assertThat(getResponse2.getBody().getInventory()).isEqualTo(100);
        assertThat(getResponse2.getBody().getBrand()).isEqualTo("Sony");
    }
}
