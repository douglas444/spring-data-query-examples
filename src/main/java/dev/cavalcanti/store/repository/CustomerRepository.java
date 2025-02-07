package dev.cavalcanti.store.repository;

import java.util.List;

import dev.cavalcanti.store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByActiveAndPurchasesProductCodeOrderByIdAsc(boolean active, String productCode);

}