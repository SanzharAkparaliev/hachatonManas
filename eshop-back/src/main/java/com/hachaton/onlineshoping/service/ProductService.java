package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.entity.Comment;
import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.entity.User;

import java.util.List;

public interface ProductService {
    Product get(Long id);
    Product getByName(String name);
    Product save(Product product);
    List<Product> getAll();
    List<Product> getProductByCategory(Category category);
}
