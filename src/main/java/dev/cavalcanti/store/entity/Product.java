package dev.cavalcanti.store.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Purchase> purchases;
    public Product() {
    }

    public Product(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public Double getPrice() {
        return price;
    }

}