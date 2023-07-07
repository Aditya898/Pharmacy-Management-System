package com.Aditya.ProfileManagement.Service;

import com.Aditya.ProfileManagement.Model.User;

public interface UserService {
    User register(User user, String plainPassword);
    User login(String username, String password);
    User getUserById(String id);
}
