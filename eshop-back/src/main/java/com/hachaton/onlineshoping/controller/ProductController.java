package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.model.ProductDTO;
import com.hachaton.onlineshoping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductDTO> fetchALlProducts() {
        return productService.getAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product productModel){
        return productService.save(productModel);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.get(productId);
    }

    @DeleteMapping("/{id}")
    public ProductDTO deleteProduct(@PathVariable("id") Long productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        return productService.update(productDTO);
    }
    

}
