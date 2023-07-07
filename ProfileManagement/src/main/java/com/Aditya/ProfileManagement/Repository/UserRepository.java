	package com.Aditya.ProfileManagement.Repository;
	
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Aditya.ProfileManagement.Model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}

	
