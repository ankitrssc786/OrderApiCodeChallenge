package com.code.challenge.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("orders")
public class Orders {

	@PrimaryKey
	@NotNull
	private String id;
	private Long timestamp;
	private int status;
	private double orderTotal;
	private double shippingCost;
	private String customerId;
	private String itemId;
	private int quantity;
	private String note;

	public Orders() {

	}

	public Orders(String id, Long timestamp, int status, double orderTotal, double shippingCost, String customerId,
			String itemId, int quantity, String note) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.status = status;
		this.orderTotal = orderTotal;
		this.shippingCost = shippingCost;
		this.customerId = customerId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.note = note;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}