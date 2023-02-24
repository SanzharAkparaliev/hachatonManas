package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.model.ProductDTO;
import com.hachaton.onlineshoping.repository.CategoryRepository;
import com.hachaton.onlineshoping.repository.ProductRepository;
import com.hachaton.onlineshoping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
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
        Product productInDb = product.getId() == null ? new Product() : productRepository.getById(product.getId());
        productInDb.setName(product.getName());
        productInDb.setUrls(product.getUrls());
        productInDb.setCategory(product.getCategory());
        productInDb.setPrice(product.getPrice());
        productInDb.setDescription(product.getDescription());
        return productRepository.save(productInDb);
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(Product::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Category by id: " + categoryId + " cannot be found !"));
        return productRepository.findByCategory(category);
    }

    @Override
    public ProductDTO deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product by id: " + id + " cannot be found !"));
        productRepository.delete(product);
        return product.toModel();
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(() -> new NoSuchElementException("Product by id: " + productDTO.getId() + " cannot be found !"));
        product.setDescription(productDTO.getDescription());
        product.setUrls(productDTO.getUrls());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        Product newProduct = productRepository.save(product);
        return newProduct.toModel();
    }

    @Override
    public List<Product> searchProductsByName(String query) {
        return productRepository.searchProduct(query);
    }
}
