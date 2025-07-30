package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "order_food")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameFood;
    private int priceFood;

    public Order(){}
    public Order(String name_food, int price_food){
        this.nameFood = name_food;
        this.priceFood = price_food;
    }

    public int getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(int priceFood) {
        this.priceFood = priceFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }
}
