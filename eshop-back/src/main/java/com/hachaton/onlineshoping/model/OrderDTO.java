package com.hachaton.onlineshoping.model;

import com.hachaton.onlineshoping.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private ProductDTO productId;
    private UserDTO userId;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private OrderDTO parentId;
    private String hashKey;
    private String guestEmail;

}
