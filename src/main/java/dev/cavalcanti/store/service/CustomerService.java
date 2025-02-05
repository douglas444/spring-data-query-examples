package dev.cavalcanti.store.service;

import java.util.List;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findCustomers(String email, String productCode) {
        return this.customerRepository.findCustomersByActiveAndEmailOrPurchases_ProductCode(true, email, productCode);
    }

}
