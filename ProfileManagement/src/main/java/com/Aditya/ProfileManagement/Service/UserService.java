package com.Aditya.ProfileManagement.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Aditya.ProfileManagement.Model.User;

public interface UserService {
    String registerUser(User user);
    String loginUser(User user);
}
