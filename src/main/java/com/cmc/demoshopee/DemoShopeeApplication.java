package com.cmc.demoshopee;

import com.cmc.demoshopee.entity.Role;
import com.cmc.demoshopee.entity.User;
import com.cmc.demoshopee.entity.UserRole;
import com.cmc.demoshopee.service.UserService;
import com.cmc.demoshopee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoShopeeApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DemoShopeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting code");

//        User user1 = new User();
//        user1.setUsername("duong");
//        user1.setPassword("123456");
//        user1.setEmail("duong@gmail.com");
//        user1.setProfile("default.png");
//
//        Role role1 = new Role();
//        role1.setRoleId(44);
//        role1.setRoleName("ADMIN");
//
//        Set<UserRole> userRoleSet = new HashSet<>();
//        UserRole userRole = new UserRole();
//        userRole.setRole(role1);
//        userRole.setUser(user1);
//        userRoleSet.add(userRole);
//
//        User user = this.userService.createUser(user1, userRoleSet);
//        System.out.println(user.getUsername());
    }
}
