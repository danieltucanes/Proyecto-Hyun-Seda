package com.unicauca.clientuserhttpclient.domain.services;

import com.unicauca.clientuserhttpclient.domain.entities.User;
import java.util.List;
import com.unicauca.clientuserhttpclient.access.IUserRepository;

public class UserService {

    IUserRepository repo;

    public UserService(IUserRepository repo) {
        this.repo = repo;
    }

    public List<User> findDifferentRoleVisitor(String token){
        return repo.findDifferentRoleVisitor(token);
    }
    
    public void create(User user, String token){
        repo.create(user,token);
    }
    public void login(User user){
        repo.login(user);
    }
    
    public User findById(Long id,String token){
        return repo.findById(id,token);
    }
    
    public void edit(Long id, User userUpdated,String token){
        repo.edit(id, userUpdated,token);
    }
    
    public void delete(Long id,String token){
        repo.delete(id,token);
    }
    
}
