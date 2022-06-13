package com.cmc.demoshopee.service.impl;

import com.cmc.demoshopee.entity.User;
import com.cmc.demoshopee.entity.UserRole;
import com.cmc.demoshopee.exception.NotFoundException;
import com.cmc.demoshopee.exception.UserFoundExeption;
import com.cmc.demoshopee.repository.RoleRepository;
import com.cmc.demoshopee.repository.UserRepository;
import com.cmc.demoshopee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            System.out.println("Username is existed !!");
            throw new UserFoundExeption();
        } else {
            //user create
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    //gettting user by username
    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    //delete user by id
    @Override
    public void deleteUserById(int userId) {
        this.userRepository.deleteById(userId);
    }

}
