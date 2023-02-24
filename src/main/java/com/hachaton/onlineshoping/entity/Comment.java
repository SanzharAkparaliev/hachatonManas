package com.hachaton.onlineshoping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;
}
