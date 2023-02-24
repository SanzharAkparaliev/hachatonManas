package com.hachaton.onlineshoping.model;

import com.hachaton.onlineshoping.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;

    private String description;
    private List<String> urls;
    private BigDecimal price;

    Category category;
}
