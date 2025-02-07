package dev.cavalcanti.store.controller;

import java.util.List;

import dev.cavalcanti.store.service.CatalogService;
import dev.cavalcanti.store.view.CatalogView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalogs")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<CatalogView> getCatalogs() {
        return catalogService.getCatalogs();
    }

}
