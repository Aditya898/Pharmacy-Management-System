package com.Aditya.OrderManagement.Service;

import java.util.List;

import com.Aditya.OrderManagement.Model.Order;

public interface OrderService {
    Order createOrder(Order order);
    
    Order getOrder(String orderId);
    List<Order> getAllOrders();

    
    void deleteOrder(String orderId);

    
}

