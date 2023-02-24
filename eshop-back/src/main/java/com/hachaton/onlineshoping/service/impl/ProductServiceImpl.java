package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.repository.ProductRepository;
import com.hachaton.onlineshoping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product by id: " + id + " cannot be found !"));
    }

    @Override
    public Product getByName(String name) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getProductByCategory(Category category) {
        return null;
    }
}
