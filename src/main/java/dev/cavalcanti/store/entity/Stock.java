package dev.cavalcanti.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
