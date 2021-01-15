package com.springsecurity.controller;

import com.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.springsecurity.repository.UserRepository;


@RestController
@RequestMapping("/secure/rest")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/admin/add")
    public String addUser(@RequestBody User user) {
        String password = user.getPassword();
        String encryptedPassword = passwordEncoder.encode(password);
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "user added...";
    }

    @GetMapping("/hello")
    public String hello(){
        return "HELLO";
    }

//    /secure/rest/admin/add
//    /secure/rest/hello
}
