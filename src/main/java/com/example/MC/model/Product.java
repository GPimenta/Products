package com.example.MC.model;



//id (Long, auto-generated)
//name (String, unique, not null)
//price (Decimal, not null)
//inventory (Integer, not null)

import java.math.BigDecimal;
import java.util.Objects;

//TODO: Pq apagar o Id do construtor.
public class Product {

    private String productId;
    private String name;
    private BigDecimal price; // nunca usar float double porque os processadores fazem o calculo da divisao diferente. Neste caso ou uso String pq 'e mais preciso ou o Decimal
    private int inventory;
    public String brand;

    public Product() {
    }

    public Product(String productId, String name, BigDecimal price, int inventory, String brand) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.brand = brand;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return inventory == product.inventory && Objects.equals(productId, product.productId) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(brand, product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, inventory, brand);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", brand='" + brand + '\'' +
                '}';
    }
}
