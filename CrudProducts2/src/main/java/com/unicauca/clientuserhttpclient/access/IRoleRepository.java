/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.unicauca.clientuserhttpclient.access;


import com.unicauca.clientuserhttpclient.domain.entities.Role;
import java.util.List;

/**
 *
 * @author Felipe Castro
 */
public interface IRoleRepository {
    public List<Role> findAll(String token);
}
