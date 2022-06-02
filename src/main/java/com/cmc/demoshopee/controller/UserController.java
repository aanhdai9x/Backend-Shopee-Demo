package com.cmc.demoshopee.controller;

import com.cmc.demoshopee.entity.Role;
import com.cmc.demoshopee.entity.User;
import com.cmc.demoshopee.entity.UserRole;
import com.cmc.demoshopee.exception.NotFoundException;
import com.cmc.demoshopee.repository.UserRepository;
import com.cmc.demoshopee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int id){
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found for this id ::" + id));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable(name = "username") String username){
        return this.userService.findByUsername(username);
    }

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user){
        user.setProfile("default.png");
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user, roles);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int id, @RequestBody User userNew){
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found for this id ::" + id));
        user.setUsername(userNew.getUsername());
        user.setEmail(userNew.getEmail());
        user.setPassword(userNew.getPassword());
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    //delete user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(value = "userId") int userId){
        this.userService.deleteUserById(userId);
    }

}
