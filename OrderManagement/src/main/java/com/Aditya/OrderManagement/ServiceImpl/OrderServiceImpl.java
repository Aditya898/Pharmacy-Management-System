package com.Aditya.OrderManagement.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aditya.OrderManagement.Exception.OrderNotFoundException;
import com.Aditya.OrderManagement.Model.Order;
import com.Aditya.OrderManagement.Repositories.OrderRepository;
import com.Aditya.OrderManagement.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    
    
    @Override
    public Order createOrder(Order order) {
    	logger.info("Creating order: {}", order);
        order.setOrderId(generateSequentialOrderId());
       
        return orderRepository.save(order);
    }
    
    


    private String generateSequentialOrderId() {
        List<Order> allOrders = orderRepository.findAll();
        int nextId = allOrders.size() + 1;
        return "ORD" + String.format("%04d", nextId);
    }

    
    
    
    
    
    @Override
    public List<Order> getAllOrders() {
    	 logger.info("Fetching all orders");
        return orderRepository.findAll();
    }

    

    @Override
    public Order getOrder(String orderId) {
    	 logger.info("Fetching order with ID: {}", orderId);
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }
        logger.info("Order found: {}", order);
        return order;
    }

    @Override
    public void deleteOrder(String orderId) {
    	logger.info("Deleting order with ID: {}", orderId);
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException("Order not found with ID: " + orderId);
        }
        orderRepository.delete(order);
        logger.info("Order deleted successfully: {}", order);
    }
    }

    

