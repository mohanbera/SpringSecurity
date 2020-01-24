package com.example.demo.Initialize;

import com.example.demo.Model.user;
import com.example.demo.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class dbInitializr implements CommandLineRunner
{

    @Autowired
    userRepository userRepositoryA;

    private PasswordEncoder passwordEncoder;

    public dbInitializr(PasswordEncoder passwordEncoder) {

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args)
    {
        /*
        // create new users
        userRepositoryA.deleteAll();
        user mohan = new user ("Mohan", passwordEncoder.encode("mohan123"), "USER", "");
        user admin = new user("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1,ACTION_TEST2");
        user manager = new user("manager", passwordEncoder.encode("manager123"), "MANAGER", "ACCESS_TEST1");

        List<user> userList = Arrays.asList(mohan, admin, manager);

        // store into database
        this.userRepositoryA.saveAll(userList);

         */
    }


}
