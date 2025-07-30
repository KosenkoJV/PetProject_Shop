package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class Controller {

    private final OrderRepository orderRepository;
    private final GetPriceService getPriceService;

    private Controller(OrderRepository orderRepository,
                       GetPriceService getPriceService){
        this.orderRepository = orderRepository;
        this.getPriceService = getPriceService;
    }

    @PostMapping("/order")
    public Order order(
            @RequestParam String name_food,
            @RequestParam int price_food){
        Order foodObject = new Order();
        foodObject.setNameFood(name_food);
        foodObject.setPriceFood(price_food);
        return orderRepository.save(foodObject);
    }
    @GetMapping("/price")
    public int Price(
            @RequestParam String name_food,
            @RequestParam int count_food){
        return getPriceService.getPrice(name_food, count_food);
    }

}

//Invoke-WebRequest -Uri "http://localhost:8080/delivery/order" -Method POST -Body @{
  //  name_food = "bread"
    // price_food = "55"}

// Invoke-WebRequest -Uri "http://localhost:8080/delivery/price?name_food=bread&count_food=2" -Method GET
