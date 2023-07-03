package com.Aditya.SupplierService.Service;



import java.util.List;

import com.Aditya.SupplierService.Model.Supplier;

public interface SupplierService {
    Supplier getSupplierById(String id);
    List<Supplier> getAllSuppliers();
    Supplier addSupplier(Supplier supplier);
    Supplier updateSupplier(String id, Supplier supplier);
    void deleteSupplier(String id);
}

