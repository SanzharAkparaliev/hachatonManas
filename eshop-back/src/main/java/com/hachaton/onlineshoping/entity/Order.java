package com.hachaton.onlineshoping.entity;

import com.hachaton.onlineshoping.enums.OrderStatus;
import com.hachaton.onlineshoping.model.OrderDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table( name = "ORDER")
@SequenceGenerator(name = "id_generator", sequenceName = "ORDER_SEQ", allocationSize = 1)
public class Order extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Order parentId;
    private String hashKey;

    private String guestEmail;

    public OrderDTO toModel() {
        return OrderDTO.builder()
                .id(id)
                .userId(userId.toModel())
                .productId(productId.toModel())
                .parentId(parentId.toModel())
                .hashKey(hashKey)
                .build();
    }
}
