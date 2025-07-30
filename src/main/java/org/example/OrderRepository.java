package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByNameFood(String name_food);
}
