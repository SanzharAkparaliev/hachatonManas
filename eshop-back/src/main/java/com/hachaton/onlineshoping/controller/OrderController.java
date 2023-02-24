package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.model.OrderDTO;
import com.hachaton.onlineshoping.model.ProductDTO;
import com.hachaton.onlineshoping.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save")
    public OrderDTO makeOrder(List<ProductDTO> products, String guestEmail, String hashKey) {
        return orderService.orderProduct(products, guestEmail, hashKey);
    }


    @GetMapping("/list")
    public List<OrderDTO> fetchAllOrders() {
        return orderService.findAll();
    }
}
