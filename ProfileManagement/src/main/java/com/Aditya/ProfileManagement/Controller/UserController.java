package com.Aditya.ProfileManagement.Controller;

import com.Aditya.ProfileManagement.Model.User;
import com.Aditya.ProfileManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String response = userService.registerUser(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        String response = userService.loginUser(user);
        return ResponseEntity.ok(response);
    }
}