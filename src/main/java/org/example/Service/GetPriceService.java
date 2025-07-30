package org.example.Service;

import org.example.Product;
import org.example.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetPriceService {
    private final ProductRepository productRepository;

    private GetPriceService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public int getPrice(String name_product, int count_product){
Product product = productRepository.findByNameProduct(name_product);
if (name_product != null)
    return count_product * product.getPriceProduct();
return 0;
    }
}
