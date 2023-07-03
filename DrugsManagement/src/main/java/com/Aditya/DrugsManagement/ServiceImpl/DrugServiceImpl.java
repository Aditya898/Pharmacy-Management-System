package com.Aditya.DrugsManagement.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Aditya.DrugsManagement.Exception.DrugNotFoundException;
import com.Aditya.DrugsManagement.Model.Drug;
import com.Aditya.DrugsManagement.Repositories.DrugRepository;
import com.Aditya.DrugsManagement.Service.DrugService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {
	
    private final Logger logger = LoggerFactory.getLogger(DrugServiceImpl.class);

    private final DrugRepository drugRepository;


    @Autowired
    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public List<Drug> getAllDrugs() {
        logger.info("Fetching all drugs");

        return drugRepository.findAll();
    }

    
    @Override
    public Optional<Drug> getDrugById(String id) {
    	 logger.info("Fetching drug with ID: {}", id);
        Optional<Drug> optionalDrug = drugRepository.findById(id);
        if (optionalDrug.isPresent()) {
            return optionalDrug;
        } else {
            throw new DrugNotFoundException("Drug not found with ID: " + id);
        }
    }

    
    @Override
    public Drug createDrug(Drug drug) {
    	 logger.info("Creating drug: {}", drug);
    	drug.setId(generateSequentialId());
        return drugRepository.save(drug);
    }
    
    private String generateSequentialId() {
        List<Drug> allDrugs = drugRepository.findAll();
        int nextId = allDrugs.size() + 1;
        return "D" + String.format("%04d", nextId);
    }
  

    @Override
    public Drug updateDrug(String id, Drug updatedDrug) {
    	logger.info("Updating drug with ID: {}", id);
        Optional<Drug> optionalDrug = drugRepository.findById(id);
        if (optionalDrug.isPresent()) {
            Drug drug = optionalDrug.get();
            drug.setName(updatedDrug.getName());
            drug.setDescription(updatedDrug.getDescription());
            drug.setPrice(updatedDrug.getPrice());
            drug.setQuantity(updatedDrug.getQuantity());
            logger.info("Drug updated successfully");
            return drugRepository.save(drug);
        }
        else {
            throw new DrugNotFoundException("Drug not found with ID: " + id);
        } 
    }

    @Override
    public boolean deleteDrug(String id) {
    	 logger.info("Deleting drug with ID: {}", id);
        if (drugRepository.existsById(id)) {
            drugRepository.deleteById(id);
            logger.info("Drug deleted successfully");
            return true;
        }
        else {
            throw new DrugNotFoundException("Drug not found with ID: " + id);
        }
    }
    
    
    
    @Override
    public List<Drug> getDrugsByExpiryDate( LocalDate expiryDate) {
    	logger.info("Fetching drugs by expiry date: {}", expiryDate);
        List<Drug> drugs = drugRepository.findByExpiryDate(expiryDate);
        if (drugs.isEmpty()) {
            throw new DrugNotFoundException("No drugs found for expiry date: " + expiryDate);
        }
        return drugs;
    }
    

}

