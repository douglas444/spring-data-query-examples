package dev.cavalcanti.store.service;

import java.util.List;

import dev.cavalcanti.store.entity.Product;
import dev.cavalcanti.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> find(Double min, Double max) {
        return this.productRepository.find(min, max);
    }

}
