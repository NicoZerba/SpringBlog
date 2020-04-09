/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconi.repository;

import it.marconi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nicolò
 */
public interface PostRepo extends JpaRepository<Post, Long>{
    
}
