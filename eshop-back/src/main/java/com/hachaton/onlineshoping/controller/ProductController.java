package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.model.OrderDTO;
import com.hachaton.onlineshoping.model.ProductDTO;
import com.hachaton.onlineshoping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductDTO> fetchALlProducts() {
        return productService.getAll();
    }
    

}
