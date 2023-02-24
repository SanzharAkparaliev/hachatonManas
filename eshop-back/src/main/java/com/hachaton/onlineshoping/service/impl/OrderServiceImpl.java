package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.Order;
import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.enums.OrderStatus;
import com.hachaton.onlineshoping.model.OrderDTO;
import com.hachaton.onlineshoping.model.ProductDTO;
import com.hachaton.onlineshoping.repository.OrderRepository;
import com.hachaton.onlineshoping.repository.ProductRepository;
import com.hachaton.onlineshoping.service.OrderService;
import com.hachaton.onlineshoping.service.ProductService;
import com.hachaton.onlineshoping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductRepository productRepository;
    @Override
    public OrderDTO orderProduct(List<ProductDTO> products, String guestEmail, String hashKey) {
        Optional<Order> parentOrderOptional = Optional.empty();
        Optional<User> userOptional = Optional.ofNullable(userService.getCurrentUser());
        Order resultOrder;
        if (products.size() > 1){
            Order parentOrder = new Order();
            parentOrder.setStatus(OrderStatus.NEW);
            if (userOptional.isPresent()) {
                parentOrder.setUserId(userOptional.get());
            } else {
                parentOrder.setHashKey(hashKey);
                parentOrder.setGuestEmail(guestEmail);
            }
            parentOrderOptional = Optional.of(orderRepository.save(parentOrder));
            resultOrder = parentOrderOptional.get();
        } else {
            resultOrder = orderRepository.save(this.createOrder(products.get(0).getId(), parentOrderOptional));
        }
        Optional<Order> finalParentOrderOptional = parentOrderOptional;
        products.stream().map(product -> createOrder(product.getId(), finalParentOrderOptional))
                .forEach(orderRepository::save);

        return  resultOrder.toModel();
    }

    @Override
    public List<OrderDTO> findAll() {
        return null;
    }

    private Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    private Order createOrder(Long productId, Optional<Order> parentOrderOptional) {
        Product product = productRepository.findById(productId).orElseThrow(NoSuchElementException::new);

        Order order = new Order();
        order.setProductId(product);
        order.setStatus(OrderStatus.NEW);

        parentOrderOptional.ifPresent(order::setParentId);
        return order;
    }

}
