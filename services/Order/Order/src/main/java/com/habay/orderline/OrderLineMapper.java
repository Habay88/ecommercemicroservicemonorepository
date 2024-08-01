package com.habay.orderline;


import org.springframework.stereotype.Service;

@Service
public class OrderLineMaper {
    public OrderlIne toOrderLine(OrderLinerRequest request){
        return OrderLine.builder()
                .id(request.orderId)
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }
}
