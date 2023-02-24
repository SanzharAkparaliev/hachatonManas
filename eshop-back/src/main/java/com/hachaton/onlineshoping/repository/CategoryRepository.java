package com.hachaton.onlineshoping.repository;

import com.hachaton.onlineshoping.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
