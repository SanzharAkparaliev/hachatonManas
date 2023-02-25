package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.model.ProductDTO;
import com.hachaton.onlineshoping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

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

    @GetMapping("/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable("id") Long categoryId){
        return productService.getProductByCategory(categoryId);
    }

    @GetMapping("/search")
    public List<Product> searchProductByName(@RequestParam("productName") String query){
        return productService.searchProductsByName(query);
    }
    @GetMapping("/filterbyprice")
    public List<Product> getProductsbetweenByPrice(@RequestParam("startPrice") BigDecimal start,
                                              @RequestParam("endPrice") BigDecimal end){
        return productService.priceBetweenByPrice(start,end);
    }

    @GetMapping("/filterbydate")
    public List<Product> getProductsbetweenByDate(@RequestParam("startDate") LocalDateTime start,
                                              @RequestParam("endPrice") LocalDateTime end){
        return productService.priceBetweenByDate(start,end);
    }
    

}
