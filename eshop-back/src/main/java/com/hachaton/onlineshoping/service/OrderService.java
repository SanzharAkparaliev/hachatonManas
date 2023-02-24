package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.model.OrderDTO;
import com.hachaton.onlineshoping.model.ProductDTO;

import java.util.List;

public interface OrderService {
    OrderDTO orderProduct(List<ProductDTO> products, String guestEmail, String hashKey);
    List<OrderDTO> findAll();
}
