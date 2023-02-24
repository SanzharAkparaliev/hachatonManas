package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/list")
    public List<Category> getAllCategory(){
        return  categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long categoryId){
        return categoryService.get(categoryId);
    }

    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable("id") Long categoryId){
        return categoryService.delete(categoryId);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category){
        return categoryService.update(category);
    }
    @PostMapping
    public Category creatingCategory(@RequestBody Category category){
        return categoryService.create(category);
    }
}
