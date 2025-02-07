package dev.cavalcanti.store.service;

import java.util.List;

import dev.cavalcanti.store.entity.Stock;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Stock> getEmptyStocks() {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Stock> query = builder.createQuery(Stock.class);
        Root<Stock> root = query.from(Stock.class);

        Predicate isEmpty = builder.equal(root.get("quantity"), 0);
        query.where(isEmpty);

        return this.entityManager.createQuery(query).getResultList();

    }

}
