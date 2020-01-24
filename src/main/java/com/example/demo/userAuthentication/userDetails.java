package com.example.demo.userAuthentication;

import com.example.demo.Model.user;
import com.example.demo.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class userDetails implements UserDetailsService
{
    @Autowired
    private userRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {

        System.out.println(s);
        user myUser=this.userRepository.findByUsername(s);
        if(myUser==null)
        {
            return null;
        }
        userPrinciple userPrinciple=new userPrinciple(myUser);
        return userPrinciple;
    }
}
