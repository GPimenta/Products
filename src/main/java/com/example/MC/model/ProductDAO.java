package com.example.MC.model;



//id (Long, auto-generated)
//name (String, unique, not null)
//price (Decimal, not null)
//inventory (Integer, not null)

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

//TODO: Pq apagar o Id do construtor.
@Entity
@Table(name = "products")
public class ProductDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="product_id", unique = true, nullable = false)
    private String productId;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)// nunca usar float double porque os processadores fazem o calculo da divisao diferente. Neste caso ou uso String pq 'e mais preciso ou o Decimal
    private int inventory;
    @Column(nullable = false)
    private boolean available;
    @Column(nullable = false)
    private String brand;

    public ProductDAO() {
    }

    public ProductDAO(String productId, String name, BigDecimal price, int inventory, boolean available, String brand) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
        this.available = available;
        this.brand = brand;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getId() {
        return id;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
        ProductDAO that = (ProductDAO) o;
        return id == that.id && inventory == that.inventory && available == that.available && Objects.equals(productId, that.productId) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, id, name, price, inventory, available, brand);
    }

    @Override
    public String toString() {
        return "ProductDAO{" +
                "productId='" + productId + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", available=" + available +
                ", brand='" + brand + '\'' +
                '}';
    }
}

