package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.model.OrderDTO;
import com.hachaton.onlineshoping.repository.OrderRepository;
import com.hachaton.onlineshoping.service.OrderService;
import com.hachaton.onlineshoping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    @Override
    public OrderDTO orderProduct(Long productId, Long UserId, Long parentId) {
        return null;
    }

    @Override
    public List<OrderDTO> findAll() {
        return null;
    }
}
