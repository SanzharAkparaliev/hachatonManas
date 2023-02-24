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
    public Category update(Category category) {
        Category categoryInDb = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + category.getId() + " cannot be found !"));
        categoryInDb.setName(category.getName());
        return categoryRepository.save(categoryInDb);
    }

    @Override
    public Category create(Category categoryModel) {
        Category category = categoryModel.getId() == null ? new Category() : categoryRepository.getById(categoryModel.getId());
        return categoryRepository.save(category);
    }

}
