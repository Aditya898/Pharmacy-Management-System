package com.Aditya.OrderManagement.Controller;

import com.Aditya.OrderManagement.Model.Order;
import com.Aditya.OrderManagement.Service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderController = new OrderController(orderService);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order();
        when(orderService.createOrder(order)).thenReturn(order);

        Order createdOrder = orderController.createOrder(order);

        assertEquals(order, createdOrder);
        verify(orderService).createOrder(order);
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = Collections.singletonList(new Order());
        when(orderService.getAllOrders()).thenReturn(orders);

        List<Order> retrievedOrders = orderController.getAllOrders();

        assertEquals(orders, retrievedOrders);
        
    }

    @Test
    void testGetOrder() {
        String orderId = "123";
        Order order = new Order();
        when(orderService.getOrder(orderId)).thenReturn(order);

        Order retrievedOrder = orderController.getOrder(orderId);

        assertEquals(order, retrievedOrder);
        
    }

    @Test
    void testDeleteOrder() {
        String orderId = "123";

        orderController.deleteOrder(orderId);

        
    }
}
