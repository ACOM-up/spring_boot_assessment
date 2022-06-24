/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.regApp.repo;

import com.example.regApp.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Arosha
 */
public interface UserRepo extends JpaRepository<UserDetails, Long>{
    
}
