package com.Aditya.OrderManagement.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    //private String id;
    private String orderId;
    private Date orderDate;
    private String customerName;
    private String customerId;
    private String contactInformation;
    private List<OrderItem> orderItems;
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Order( String orderId, Date orderDate, String customerName, String customerId,
			String contactInformation, List<OrderItem> orderItems) {
		super();
//		this.id = id;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerId = customerId;
		this.contactInformation = contactInformation;
		this.orderItems = orderItems;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
