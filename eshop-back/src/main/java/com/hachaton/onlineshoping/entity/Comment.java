package com.hachaton.onlineshoping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMMENT")
@SequenceGenerator(name = "id_generator", sequenceName = "COMMENT_SEQ", allocationSize = 1)
public class Comment extends BaseEntity{

    @Column(name = "CONTENT", columnDefinition = "TEXT")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;
}
