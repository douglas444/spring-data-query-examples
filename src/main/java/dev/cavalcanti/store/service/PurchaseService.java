package dev.cavalcanti.store.service;

import java.util.List;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.entity.Product;
import dev.cavalcanti.store.entity.Purchase;
import dev.cavalcanti.store.repository.PurchaseRepository;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> findPurchases(String customerEmail,
                                        String productCode,
                                        Double productMinPrice,
                                        Double productMaxPrice) {

        Specification<Purchase> specification = Specification.where(null);

        if (customerEmail != null && !customerEmail.isBlank()) {
            specification = specification.and(customerEmailEquals(customerEmail));
        }

        if (productCode != null && !productCode.isBlank()) {
            specification = specification.and(productCodeEquals(productCode));
        }

        if (productMinPrice != null || productMaxPrice != null) {
            specification = specification.and(productPrinceBetween(productMinPrice, productMaxPrice));
        }

        return this.purchaseRepository.findAll(specification);
    }

    private Specification<Purchase> customerEmailEquals(String customerEmail) {

        if (customerEmail == null) {
            return Specification.where(null);
        }

        return (root, query, builder) -> {
            Join<Purchase, Customer> join = root.join("customer", JoinType.INNER);
            return builder.equal(join.get("email"), customerEmail);
        };

    }

    private Specification<Purchase> productCodeEquals(String productCode) {
        return (root, query, builder) -> {
            Join<Purchase, Product> join = root.join("product", JoinType.INNER);
            return builder.equal(join.get("code"), productCode);
        };
    }

    private Specification<Purchase> productPrinceBetween(Double productMinPrice, Double productMaxPrice) {
        return (root, query, builder) -> {
            Join<Purchase, Product> join = root.join("product", JoinType.INNER);
            Expression<Double> price = join.get("price");
            return builder.between(
                    price,
                    builder.coalesce(builder.literal(productMinPrice), price),
                    builder.coalesce(builder.literal(productMaxPrice), price));
        };
    }

}
