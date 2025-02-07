package dev.cavalcanti.store.service;

import java.util.List;

import dev.cavalcanti.store.view.CatalogView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<CatalogView> getCatalogs() {
        String query = """
            SELECT
                p.code AS code,
                p.price AS price,
                s.quantity AS quantity,
                r.rating AS rating
            FROM
                product p
                    JOIN stock s ON p.code = s.code
                    JOIN rating r ON p.code = r.code
            ORDER BY rating DESC
            """;
        return this.entityManager.createNativeQuery(query, CatalogView.class).getResultList();
    }



}
