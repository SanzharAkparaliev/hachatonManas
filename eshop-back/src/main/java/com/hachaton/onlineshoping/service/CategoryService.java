package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.Category;

import java.util.List;

public interface CategoryService {
    Category get(Long id);
    Category getByName(String name);
    List<Category> getAll();

    Category delete(Long id);

    Category update(Category category);
    Category create(Category category);
}
