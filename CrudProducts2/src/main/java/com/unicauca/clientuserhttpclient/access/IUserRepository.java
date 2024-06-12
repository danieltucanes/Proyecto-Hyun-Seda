package com.unicauca.clientuserhttpclient.access;

import com.unicauca.clientuserhttpclient.domain.entities.User;
import java.util.List;

public interface IUserRepository {

    public List<User> findDifferentRoleVisitor(String token);

    User findById(Long id,String token);

    public void create(User user ,String token);

    public void edit(Long id, User userUpdated,String token);

    public void delete(Long id,String token);
    
    public void login (User user);

}
