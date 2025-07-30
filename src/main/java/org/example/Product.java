package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameProduct;
    private int priceProduct;

    public Product(){}

    public int getId() {
        return id;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int price_product) {
        this.priceProduct = price_product;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String name_product) {
        this.nameProduct = name_product;
    }
}
