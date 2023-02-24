package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.repository.CategoryRepository;
import com.hachaton.onlineshoping.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category get(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + id + " cannot be found !"));
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Category by name: " + name + " cannot be found !"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + id + " cannot be found !"));
        categoryRepository.delete(category);
        return category;
    }

    @Override
    public Category update(Long id, String name) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + id + " cannot be found !"));
        category.setName(name);
        return categoryRepository.save(category);
    }

}
