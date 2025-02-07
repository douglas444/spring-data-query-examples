package dev.cavalcanti.store.controller;

import java.util.List;

import dev.cavalcanti.store.entity.Stock;
import dev.cavalcanti.store.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {

    private final StockService stockService;

    public StockController(final StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/empty")
    public List<Stock> getEmptyStocks() {
        return stockService.getEmptyStocks();
    }

}
