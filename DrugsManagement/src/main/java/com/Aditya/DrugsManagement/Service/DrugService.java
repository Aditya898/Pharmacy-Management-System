package com.Aditya.DrugsManagement.Service;

import java.util.List;
import java.util.Optional;

import com.Aditya.DrugsManagement.Model.Drug;

public interface DrugService {
    List<Drug> getAllDrugs();
    Optional<Drug> getDrugById(String id);
    Drug createDrug(Drug drug);
    Drug updateDrug(String id, Drug updatedDrug);
    boolean deleteDrug(String id);
}
