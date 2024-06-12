/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.clientuserhttpclient.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.security.Permission;
import java.util.List;

/**
 *
 * @author Felipe Castro
 */

public class Role {
//     @JsonProperty("id")
//    private Long roleId;
//     
//     @JsonProperty("roleName")
//    private String roleName;
//     @JsonProperty("roleEnum")
//     private String roleEnum; // Agrega esta línea
//   // Si esta es la propiedad correcta, entonces no es necesario
//     @JsonProperty("permissionList")
//    private List<Permission> permissionList;
//
//    public Long getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Long roleId) {
//        this.roleId = roleId;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
     @JsonProperty("id")
    private Long roleId;

    @JsonProperty("roleName")
    private String roleName;

    @JsonProperty("roleEnum")
    private String roleEnum;

    @JsonProperty("permissionList")
    private List<Permission> permissionList;

    public Long getRoleId() {
        return roleId;
    }
   
   
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(String roleEnum) {
        this.roleEnum = roleEnum;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
    
    
    
}
