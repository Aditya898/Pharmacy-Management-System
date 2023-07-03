package com.Aditya.SupplierService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Aditya.SupplierService.Model.Supplier;

public interface SupplierRepository extends MongoRepository<Supplier, String> {
    // You can define additional query methods here if needed
}

