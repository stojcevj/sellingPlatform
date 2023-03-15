package com.example.sellingPlatform.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToMany
    private List<Product> productList;

    @ManyToOne
    private User user;

    private LocalDateTime dateCreated;

    public ShoppingCart(){

    }
}
