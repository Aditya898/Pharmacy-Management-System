package com.Aditya.OrderManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aditya.OrderManagement.Exception.OrderNotFoundException;
import com.Aditya.OrderManagement.Model.Order;
import com.Aditya.OrderManagement.Repositories.OrderRepository;
import com.Aditya.OrderManagement.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        
        return orderRepository.save(order);
    }
    
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    

    @Override
    public Order getOrder(String orderId) {
        
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }
        return order;
    }

    @Override
    public void deleteOrder(String orderId) {
     
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }
        orderRepository.delete(order);
    }

    
}
