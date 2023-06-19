package com.Aditya.DrugsManagement.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Aditya.DrugsManagement.Model.Drug;

@Repository
public interface DrugRepository extends MongoRepository<Drug, String> {
    // Additional custom query methods can be added here if needed
	 List<Drug> findByExpiryDate(LocalDate expiryDate);
}
