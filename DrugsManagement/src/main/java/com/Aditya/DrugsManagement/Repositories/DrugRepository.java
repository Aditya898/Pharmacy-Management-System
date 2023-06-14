package com.Aditya.DrugsManagement.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Aditya.DrugsManagement.Model.Drug;

@Repository
public interface DrugRepository extends MongoRepository<Drug, String> {
    // Additional custom query methods can be added here if needed
}
