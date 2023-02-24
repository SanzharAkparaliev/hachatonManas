package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.model.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO orderProduct(Long productId, Long UserId, Long parentId);
    List<OrderDTO> findAll();
}
