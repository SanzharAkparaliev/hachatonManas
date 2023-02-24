package com.hachaton.onlineshoping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
    private List<String> urls;
    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    Category category;

    @OneToMany(mappedBy = "product")
    private Set<Comment> comments;

}