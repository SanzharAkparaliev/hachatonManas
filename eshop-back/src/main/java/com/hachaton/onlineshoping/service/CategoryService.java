package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.Category;

import java.util.List;

public interface CategoryService {
    Category get(Long id);
    Category getByName(String name);
    Category save(Category category);
    List<Category> getAll();
}
