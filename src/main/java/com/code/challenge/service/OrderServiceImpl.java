package com.code.challenge.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.code.challenge.model.Orders;
import com.code.challenge.repository.OrderRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	OrderRepository orderRepository;

	/**
	 * Get Order Details by OrderId
	 */
	@Override
	public Mono<Orders> getOrderById(String id) {
		log.info("Id: " + id);
		return orderRepository.getOrderById(id);
	}

	/**
	 * Create Orders
	 */
	@Override
	public Flux<Orders> saveOrders(List<Orders> orderList) {
		log.info("Orders: " + orderList.size());
		return orderRepository.saveAll(orderList);

	}

}
