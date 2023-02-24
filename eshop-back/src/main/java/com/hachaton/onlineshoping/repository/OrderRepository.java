package com.hachaton.onlineshoping.repository;

import com.hachaton.onlineshoping.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
