/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.clientuserhttpclient.domain.services;

import com.unicauca.clientuserhttpclient.access.IRoleRepository;
import com.unicauca.clientuserhttpclient.domain.entities.Role;
import java.util.List;

/**
 *
 * @author Felipe Castro
 */
public class RoleService {
    
    IRoleRepository repo;
    
    public RoleService(IRoleRepository repo) {
        this.repo = repo;
    }

    public List<Role> findAll(String token) {
        return repo.findAll(token);
    }
    
}
