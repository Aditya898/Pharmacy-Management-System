package com.Aditya.DrugsManagement.Controller;



import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Aditya.DrugsManagement.Controller.DrugController;
import com.Aditya.DrugsManagement.Model.Drug;
import com.Aditya.DrugsManagement.Service.DrugService;

public class DrugControllerTest {

    private DrugService drugService;
    private DrugController drugController;

    @BeforeEach
    public void setUp() {
        drugService = mock(DrugService.class);
        drugController = new DrugController(drugService);
    }

    @Test
    public void testGetAllDrugs() {
       
        List<Drug> drugs = new ArrayList<>();
        drugs.add(new Drug("Drug1", "Description1", 10.0, 100));
        drugs.add(new Drug("Drug2", "Description2", 20.0, 200));

        when(drugService.getAllDrugs()).thenReturn(drugs);

       
        List<Drug> result = drugController.getAllDrugs();

        assertEquals(drugs, result);
       
    }

    @Test
    public void testGetDrugById() {
        String drugId = "12345";
        Drug drug = new Drug("Drug1", "Description1", 10.0, 100);
        drug.setId(drugId);

        when(drugService.getDrugById(drugId)).thenReturn(Optional.of(drug));

      
        Optional<Drug> result = drugController.getDrugById(drugId);

        assertTrue(result.isPresent());
        assertEquals(drug, result.get());
        
    }

    

}

