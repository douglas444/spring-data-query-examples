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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;

    private boolean active;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public boolean isActive() {
        return active;
    }

}
