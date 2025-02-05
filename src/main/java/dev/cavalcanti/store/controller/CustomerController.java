package dev.cavalcanti.store.controller;

import java.util.List;

import dev.cavalcanti.store.entity.Customer;
import dev.cavalcanti.store.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findCustomers(@RequestParam(required = false) String email,
                                        @RequestParam(required = false) String purchaseProductCode) {
        return this.customerService.findCustomers(email, purchaseProductCode);
    }

}
