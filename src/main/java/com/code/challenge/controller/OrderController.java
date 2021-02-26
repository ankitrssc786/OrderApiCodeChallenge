package com.code.challenge.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.code.challenge.exception.OrderNotFoundException;
import com.code.challenge.model.Orders;
import com.code.challenge.service.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderService orderService;

	/**
	 * Get Order Details By OrderId
	 * 
	 * @param orderId
	 * @return
	 */
	@GetMapping("/{orderId}")
	public Mono<Orders> getOrderById(@PathVariable UUID orderId) {
		log.info("Order Id: " + orderId);
		return orderService.getOrderById(orderId.toString())
				.switchIfEmpty(Mono.error(new OrderNotFoundException(orderId)));
	}

	/**
	 * Create Orders (either single or multiple)
	 * 
	 * @param orderList
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Flux<Orders> createOrders(@Valid @RequestBody List<Orders> orderList) {
		log.info("Order size Controller: " + orderList.size());
		return orderService.saveOrders(orderList);
	}

}
