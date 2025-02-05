package dev.cavalcanti.store.controller;

import java.util.List;

import dev.cavalcanti.store.entity.Product;
import dev.cavalcanti.store.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findProductsWithPriceInRange(@RequestParam(required = false) Double minPrice,
                                                      @RequestParam(required = false) Double maxPrice) {
        return this.productService.findProducts(minPrice, maxPrice);
    }

}
