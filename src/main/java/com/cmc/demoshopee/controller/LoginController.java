package com.cmc.demoshopee.controller;

import com.cmc.demoshopee.entity.User;
import com.cmc.demoshopee.exception.NotFoundException;
import com.cmc.demoshopee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    public UserRepository userRepository;

    @PostMapping()
    public Map<String, String> login(@RequestBody User userLogin){
        Map<String, String> message= new HashMap<>();
        User user = userRepository.findByUsernameAndPassword(userLogin.getUsername(), userLogin.getPassword()).orElseThrow(()-> new NotFoundException("Login fail !"));
        message.put("message", "Login success !");
        return message;
    }
}
