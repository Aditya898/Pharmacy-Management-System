package com.Aditya.DrugsManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Aditya.DrugsManagement.Model.Drug;
import com.Aditya.DrugsManagement.Service.DrugService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drugs")
public class DrugController {
    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    
    //Get list of all the drugs
    @GetMapping
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    //Get a specific drug by proving id as a input
    @GetMapping("/{id}")
    public Optional<Drug> getDrugById(@PathVariable String id) {
        return drugService.getDrugById(id);
    }

    //create a new drug
    @PostMapping
    public Drug createDrug(@RequestBody Drug drug) {
        return drugService.createDrug(drug);
    }

    //update a existing drug
    @PutMapping("/{id}")
    public Drug updateDrug(@PathVariable String id, @RequestBody Drug updatedDrug) {
        return drugService.updateDrug(id, updatedDrug);
    }

   //delete a drug
    @DeleteMapping("/{id}")
    public boolean deleteDrug(@PathVariable String id) {
        return drugService.deleteDrug(id);
    }
    
    
    @GetMapping("/expiry/{expiryDate}")
    public List<Drug> getDrugsByExpiryDate(@PathVariable("expiryDate") String expiryDate) {
        LocalDate date = LocalDate.parse(expiryDate, DateTimeFormatter.ISO_DATE);
        return drugService.getDrugsByExpiryDate(date);
    }

}
