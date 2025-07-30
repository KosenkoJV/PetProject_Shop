package org.example;

import org.springframework.stereotype.Service;

@Service
public class GetPriceService {
    private final OrderRepository orderRepository;

    private GetPriceService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public int getPrice(String name_food, int count_food){
Order order = orderRepository.findByNameFood(name_food);
if (name_food != null)
    return count_food * order.getPriceFood();
return 0;
    }
}
