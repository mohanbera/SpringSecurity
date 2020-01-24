package com.example.demo.Controller;


import com.example.demo.Model.user;
import com.example.demo.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class myRestController
{
    @Autowired
    private userRepository userRepositoryA;

    @GetMapping("/my")
    public String my()
    {
        return "This is mine";
    }

    @GetMapping("/public/all")
    public String ok()
    {
        return "OK";
    }

    @GetMapping("/public/allUser")
    public List<user> allUser()
    {
        return userRepositoryA.findAll();
    }

    @GetMapping("/admin")
    public String admin(Authentication authentication)
    {
        System.out.println(authentication.getName());
        return "I am admin";
    }

    @GetMapping("/manager")
    public String manager(Authentication authentication)
    {
        System.out.println(authentication.getName());
        return "I am manager";
    }

    @GetMapping("/user")
    public String user(Authentication authentication)
    {
        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.isAuthenticated());
        return "Hi from User";
    }

}
