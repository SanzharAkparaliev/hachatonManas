package com.hachaton.onlineshoping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table( name = "CATEGORY")
@SequenceGenerator(name = "id_generator", sequenceName = "CATEGORY_SEQ", allocationSize = 1)
public class Category extends BaseEntity{
    @Column(name = "NAME")
    private String name;


}
