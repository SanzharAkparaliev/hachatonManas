package com.hachaton.onlineshoping.repository;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(Category category);

    @Query("SELECT p from Product p where p.name LIKE concat('%',:query,'%')")
    List<Product> searchProduct(String query);
}
