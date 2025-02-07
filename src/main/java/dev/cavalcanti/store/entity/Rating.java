package dev.cavalcanti.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private Double rating;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Double getRating() {
        return rating;
    }

}
