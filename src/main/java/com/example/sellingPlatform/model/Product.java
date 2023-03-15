package com.example.sellingPlatform.model;

import com.example.sellingPlatform.model.enumerations.Brand;
import com.example.sellingPlatform.model.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    private String buyPrice;

    private String sellPrice;

    private String imageUrl;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Enumerated(value = EnumType.STRING)
    private Brand brand;

    public Product(String name, String buyPrice, String sellPrice, String imageUrl) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.imageUrl = imageUrl;
    }

    public Product() {
    }
}
