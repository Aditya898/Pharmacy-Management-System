package com.Aditya.SupplierService.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aditya.SupplierService.Exception.SupplierNotFoundException;
import com.Aditya.SupplierService.Model.Supplier;
import com.Aditya.SupplierService.Repository.SupplierRepository;
import com.Aditya.SupplierService.Service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	
     Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);


    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier getSupplierById(String id) {
    	logger.info("Retrieving supplier with ID: {}", id);
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            return optionalSupplier.get();
        } else {
        	
            throw new SupplierNotFoundException("Supplier not found");
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() {
    	 logger.info("Retrieving all suppliers");
        return supplierRepository.findAll();
    }


    
    @Override
    public Supplier addSupplier(Supplier supplier) {
        supplier.setId(generateSequentialSupplierId());
        logger.info("Adding a new supplier: {}", supplier.getName());
        return supplierRepository.save(supplier);
    }
    
    
    private String generateSequentialSupplierId() {
        List<Supplier> allSuppliers = supplierRepository.findAll();
        int nextId = allSuppliers.size() + 1;
        return "SUP" + String.format("%04d", nextId);
    }
    
    @Override
    public Supplier updateSupplier(String id, Supplier supplier) {
    	 logger.info("Updating supplier with ID: {}", id);
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            Supplier existingSupplier = optionalSupplier.get();
            existingSupplier.setName(supplier.getName());
            existingSupplier.setContact(supplier.getContact());
          
            return supplierRepository.save(existingSupplier);
        } else {
            throw new SupplierNotFoundException("Supplier not found");
        }
    }

    @Override
    public void deleteSupplier(String id) {
    	logger.info("Deleting supplier with ID: {}", id);
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
        } else {
            throw new SupplierNotFoundException("Supplier not found");
        }
    }
}
