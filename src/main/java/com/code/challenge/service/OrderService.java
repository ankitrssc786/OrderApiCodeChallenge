package com.code.challenge.service;

import java.util.List;
import com.code.challenge.model.Orders;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

	Mono<Orders> getOrderById(String id);

	Flux<Orders> saveOrders(List<Orders> orderList);

}
