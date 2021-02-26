package com.code.challenge.controller;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import com.code.challenge.model.Orders;
import com.code.challenge.service.OrderServiceImpl;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@Slf4j
public class OrderControllerTest {

	@MockBean
	OrderServiceImpl serviceTest;

	@Autowired
	private WebTestClient webClient;

	@Test
	void getOrderById() {
		Orders orders = new Orders();
		orders.setId("401a85e2-f5da-494b-9f3f-756a91982f00");
		orders.setTimestamp(1612487464353L);
		orders.setStatus(1);
		orders.setOrderTotal(10.23);
		orders.setShippingCost(3.45);
		orders.setCustomerId("401a85e2-f5da-494b-9f3f-756a91982f01");
		orders.setItemId("401a85e2-f5da-494b-9f3f-756a91982f02");
		orders.setQuantity(1);
		orders.setNote("test");

		Mockito.when(serviceTest.getOrderById("401a85e2-f5da-494b-9f3f-756a91982f00")).thenReturn(Mono.just(orders));

		webClient.get().uri("/api/orders/{orderId}", "401a85e2-f5da-494b-9f3f-756a91982f00").exchange().expectStatus()
				.isOk().expectBody().jsonPath("$.id").isEqualTo("401a85e2-f5da-494b-9f3f-756a91982f00")
				.jsonPath("$.timestamp").isEqualTo(1612487464353L).jsonPath("$.status").isEqualTo(1)
				.jsonPath("$.orderTotal").isEqualTo(10.23).jsonPath("$.shippingCost").isEqualTo(3.45)
				.jsonPath("$.customerId").isEqualTo("401a85e2-f5da-494b-9f3f-756a91982f01").jsonPath("$.itemId")
				.isEqualTo("401a85e2-f5da-494b-9f3f-756a91982f02").jsonPath("$.quantity").isEqualTo(1)
				.jsonPath("$.note").isEqualTo("test");

		Mockito.verify(serviceTest, times(1)).getOrderById("401a85e2-f5da-494b-9f3f-756a91982f00");
	}

	@Test
	void testCreateOrders() {
		List<Orders> orders = new ArrayList<Orders>();
		orders.add(new Orders("401a85e2-f5da-494b-9f3f-756a91982f00", 1612487464353L, 1, 10.23, 3.45,
				"401a85e2-f5da-494b-9f3f-756a91982f01", "401a85e2-f5da-494b-9f3f-756a91982f02", 1, "test1"));
		orders.add(new Orders("401a85e2-f5da-494b-9f3f-756a91982f03", 1612487464353L, 1, 10.23, 3.45,
				"401a85e2-f5da-494b-9f3f-756a91982f04", "401a85e2-f5da-494b-9f3f-756a91982f05", 2, "test2"));

		Flux<Orders> orderFlux = Flux.fromIterable(orders);

		Mockito.when(serviceTest.saveOrders(orders)).thenReturn(orderFlux);

		webClient.post().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(orderFlux)).exchange()
				.expectStatus().isCreated();

		Mockito.verify(serviceTest, times(1)).saveOrders(orders);
	}

}
