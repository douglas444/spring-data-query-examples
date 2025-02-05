package dev.cavalcanti.store.repository;

import java.util.List;

import dev.cavalcanti.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
    SELECT DISTINCT p.* FROM product p WHERE p.price BETWEEN COALESCE(:min, p.price) AND COALESCE(:max, p.price)
    """, nativeQuery = true)
    List<Product> findProducts(Double min, Double max);

}
