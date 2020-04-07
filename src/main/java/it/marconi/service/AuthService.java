/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconi.service;

import it.marconi.dto.LoginRequest;
import it.marconi.dto.RegisterRequest;
import it.marconi.entities.User;
import it.marconi.repository.UserRepo;
import it.marconi.security.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolò
 */
@Service
public class AuthService {
    
    @Autowired
    private UserRepo userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private Jwt jwt;
    
    public void signup(RegisterRequest registerRequest) {
        User user= new User();
        user.setUserName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        
        userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public String login(LoginRequest loginRequest) {
         Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
         
            SecurityContextHolder.getContext().setAuthentication(authenticate);
           return jwt.generateToken(authenticate);
    }
    
   
    
    
}
