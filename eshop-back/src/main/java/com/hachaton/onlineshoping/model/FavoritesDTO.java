package com.hachaton.onlineshoping.model;

import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoritesDTO {
    Long id;
    Product product;

    User user;
}
