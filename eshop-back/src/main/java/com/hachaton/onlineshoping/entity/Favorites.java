package com.hachaton.onlineshoping.entity;

import com.hachaton.onlineshoping.model.FavoritesDTO;
import com.hachaton.onlineshoping.model.OrderDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "FAVORITES")
@SequenceGenerator(name = "id_generator", sequenceName = "FAVORITES_SEQ", allocationSize = 1)
public class Favorites extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Product product;

    public FavoritesDTO toModel() {
        return FavoritesDTO.builder()
                .id(id)
                .product(product)
                .user(user)
                .build();
    }

}
