package com.hachaton.onlineshoping.entity;


import com.hachaton.onlineshoping.model.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RATING")
@SequenceGenerator(name = "id_generator", sequenceName = "RATING_SEQ", allocationSize = 1)
public class Rating extends BaseEntity{
    @Column(name = "TOTAL")
    private int total;

    @Column(name = "COUNT_OF_PERSON")
    private int countOfPerson;
    @ManyToOne()
    @JoinColumn(name = "PRODUCT_ID",nullable = false)
    private Product product;
}
