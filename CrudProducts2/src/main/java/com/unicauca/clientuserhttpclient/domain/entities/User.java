package com.unicauca.clientuserhttpclient.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("id")
    private Long userId;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("email")
    private String email;
    
    @JsonProperty("password")
    private String userPassword;
    
    @JsonProperty("isEnable")
    private boolean isEnable;
    
    @JsonProperty("accountNoExpired")
    private boolean accountNoExpired;
    
    @JsonProperty("accountNoLocked")
    private boolean accountNoLocked;
    
    
     @JsonProperty("credentialsNoExpired")
    private boolean credentialsNoExpired;


    @JsonProperty("roleEnum")
    private List<Role> userRoles = new ArrayList<>();
    
     public String getUserRolesString() {
        StringBuilder rolesString = new StringBuilder();
        for (Role role : userRoles) {
            if (rolesString.length() > 0) {
                rolesString.append(", ");
            }
            rolesString.append(role.getRoleEnum());
        }
        return rolesString.toString();
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }
    
//    public String getUserRolesString(){
//        String resultado = "";
//        if(userRoles == null){
//             return "";
//        }
//        else{
//            for(Role role: userRoles){
//                resultado = resultado  + " - " + role.getRoleName();
//            }
//        }
//        return resultado;
//    }

}
