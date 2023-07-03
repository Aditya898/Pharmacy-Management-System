	package com.Aditya.ProfileManagement.ServiceImpl;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;
	
	import com.Aditya.ProfileManagement.Config.JwtUtils;
	import com.Aditya.ProfileManagement.Model.User;
	import com.Aditya.ProfileManagement.Repository.UserRepository;
	import com.Aditya.ProfileManagement.Service.UserService;
	
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;
	
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
	    public String registerUser(User user) {
	        User existingUser = userRepository.findByUsername(user.getUsername());
	        if (existingUser != null) {
	            return "Username already exists!";
	        }
	
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPassword);
	        userRepository.save(user);
	        return "User registered successfully!";
	    }
	
	    @Override
	    public String loginUser(User user) {
	        User existingUser = userRepository.findByUsername(user.getUsername());
	        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
	            // Generate JWT token
	            String token = JwtUtils.generateToken(existingUser.getUsername(), existingUser.getRole(), 86400000); // 24 hours expiration time
	
	            return token;
	        }
	        return "Invalid username or password!";
	    }
	}