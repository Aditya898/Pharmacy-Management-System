package com.Aditya.SupplierService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Aditya.SupplierService.Model.Supplier;
import com.Aditya.SupplierService.Service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") String id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return ResponseEntity.ok(supplier);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier addedSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(
            @PathVariable("id") String id,
            @RequestBody Supplier supplier
    ) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable("id") String id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
