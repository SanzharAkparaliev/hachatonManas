package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.entity.Comment;
import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.model.ProductDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {
    Product get(Long id);
    Product getByName(String name);
    Product save(Product product);
    List<ProductDTO> getAll();
    List<Product> getProductByCategory(Long categoryId);
    ProductDTO deleteProduct(Long id);

    ProductDTO update(ProductDTO productDTO);

    List<Product> searchProductsByName(String query);

    List<Product> priceBetweenByPrice(BigDecimal start,BigDecimal end);
    List<Product> priceBetweenByDate(LocalDateTime start,LocalDateTime end);
}
