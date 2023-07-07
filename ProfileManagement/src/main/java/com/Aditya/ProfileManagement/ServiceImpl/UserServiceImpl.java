package com.Aditya.ProfileManagement.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Aditya.ProfileManagement.Exception.InvalidCredentialsException;
import com.Aditya.ProfileManagement.Exception.UserNotFoundException;
import com.Aditya.ProfileManagement.Model.User;
import com.Aditya.ProfileManagement.Repository.UserRepository;
import com.Aditya.ProfileManagement.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user, String plainPassword) {
        String encodedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

//    @Override
//    public User login(String username, String password) {
//        User user = userRepository.findByUsername(username);
//        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            return user;
//        }
//        return null; // Invalid credentials
//    }
    
    
    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new InvalidCredentialsException("Invalid credentials");
    }
    
    
    

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
