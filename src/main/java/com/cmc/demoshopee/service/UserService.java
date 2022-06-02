package com.cmc.demoshopee.service;

import com.cmc.demoshopee.entity.User;
import com.cmc.demoshopee.entity.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles);

    //get user by username
    public User findByUsername(String username);

    //delete user by id
    public void deleteUserById(int userId);
}
