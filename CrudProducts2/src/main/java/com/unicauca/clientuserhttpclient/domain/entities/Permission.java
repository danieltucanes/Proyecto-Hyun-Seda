/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.clientuserhttpclient.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permission {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public Permission() {
    }
    
    
    
    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
