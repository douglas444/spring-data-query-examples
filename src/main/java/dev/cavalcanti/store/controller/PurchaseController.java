package dev.cavalcanti.store.controller;

import java.util.List;

import dev.cavalcanti.store.entity.Purchase;
import dev.cavalcanti.store.service.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> findPurchases(@RequestParam(required = false) String customerEmail,
                                        @RequestParam(required = false) String productCode,
                                        @RequestParam(required = false) Double productMinPrice,
                                        @RequestParam(required = false) Double productMaxPrice) {

        return this.purchaseService.findPurchases(
                customerEmail,
                productCode,
                productMinPrice,
                productMaxPrice);

    }

}
