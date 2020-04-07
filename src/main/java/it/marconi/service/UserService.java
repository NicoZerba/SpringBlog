/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconi.service;

import it.marconi.entities.User;
import it.marconi.repository.UserRepo;
import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolò
 */
@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    
    private UserRepo userRepo;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username).orElseThrow(()->
                new UsernameNotFoundException("No user found" + username));
            return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                true, true, true, true,
                getAuthorities("ROLE_USER"));
    }
    
    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
    
}
