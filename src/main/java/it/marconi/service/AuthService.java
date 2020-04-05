/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconi.service;

import it.marconi.dto.RegisterRequest;
import it.marconi.entities.User;
import it.marconi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolò
 */
@Service
public class AuthService {
    
    @Autowired
    private UserRepo userRepository;

    public void signup(RegisterRequest registerRequest) {
        User user= new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
    }
    
}
