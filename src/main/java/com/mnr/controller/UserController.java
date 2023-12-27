package com.mnr.controller;

import com.mnr.entity.User;
import com.mnr.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*PostConstruct annotation is used on a method that needs to be
     executed after dependency injection is done to perform any initialization*/
    @PostConstruct
    public void initRoleAndUsers(){
        userService.initRolesAndUSer();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        userService.registerNewUser(user);
        return user;
    }

    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "this URL is only accessible to admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "this url is only accessible to the user";
    }
}
