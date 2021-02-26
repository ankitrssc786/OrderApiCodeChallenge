package com.code.challenge.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import com.code.challenge.model.Orders;
import reactor.core.publisher.Mono;

@Repository
public interface OrderRepository extends ReactiveCassandraRepository<Orders, String> {

	@AllowFiltering
	Mono<Orders> getOrderById(String orderId);
}
