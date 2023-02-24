package com.hachaton.onlineshoping.entity;

import com.hachaton.onlineshoping.model.ProductDTO;
import com.hachaton.onlineshoping.model.RoleDTO;
import com.hachaton.onlineshoping.model.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(name = "id_generator", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
public class Product extends BaseEntity{
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
    @ElementCollection
    private List<String> urls;
    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    Category category;

    public ProductDTO toModel() {
        return ProductDTO.builder()
                .id(id)
                .price(price)
                .category(category)
                .description(description)
                .urls(urls)
                .name(name)
                .build();
    }

}
