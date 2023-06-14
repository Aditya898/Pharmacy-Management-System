package com.Aditya.OrderManagement.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Aditya.OrderManagement.Model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
