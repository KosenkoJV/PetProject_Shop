package org.example;

import org.example.Service.GetPriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class Controller {

    private final ProductRepository productRepository;
    private final GetPriceService getPriceService;

    private Controller(ProductRepository productRepository,
                       GetPriceService getPriceService){
        this.productRepository = productRepository;
        this.getPriceService = getPriceService;
    }

    @PostMapping("/product")
    public Product product(
            @RequestParam String name_product,
            @RequestParam int price_product){
        Product productObject = new Product();
        productObject.setNameProduct(name_product);
        productObject.setPriceProduct(price_product);
        return productRepository.save(productObject);
    }
    @GetMapping("/price")
    public int Price(
            @RequestParam String name_product,
            @RequestParam int count_product){
        return getPriceService.getPrice(name_product, count_product);
    }
    @PatchMapping("/updatePrice")
    public Product updatePrice(
            @RequestParam String name_product,
            @RequestParam int price_product){
        Product product = productRepository.findByNameProduct(name_product);
        product.setPriceProduct(price_product);
        return productRepository.save(product);
    }

}
/*
Invoke-WebRequest -Uri "http://localhost:8080/shop/product" -Method POST -Body @{
    name_product = "bread"
     price_product = "55"}

Invoke-WebRequest -Uri "http://localhost:8080/shop/price?name_product=bread&count_product=2" -Method GET

Invoke-WebRequest -Uri "http://localhost:8080/shop/updatePrice?name_product=bread&price_product=50" -Method PATCH

 */
