package com.habay.service;

import com.habay.customerclient.CustomerClient;
import com.habay.customerclient.ProductClient;
import com.habay.exception.BusinessException;
import com.habay.model.OrderMapper;
import com.habay.model.OrderRequest;
import com.habay.orderline.OrderLineService;
import com.habay.repository.OrderRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerClient customerClient;
    // private final PaymentClient paymentClient;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    // private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest request) {
        // check customer 
        var customer = this.customerClient.findCustomerById(request.customerId())
        .orElseThrow(()-> new BusinessException("Cannot create order:: No customer exists with the provided ID"));
// purchase the product ----- rest template
        var purchasedProducts = productClient.p

        // persist order 

        // persist order line

        //start payment process

        // send order confirmation to order notificaton ms -----kafka
        return null;
    }

}
