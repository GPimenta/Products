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

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getProduct() {
//        restTemplate.postForEntity()
        ResponseEntity<Product> response = restTemplate.getForEntity("/v1/products/aabb-1122", Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("dummy_name_1");
    }
}
