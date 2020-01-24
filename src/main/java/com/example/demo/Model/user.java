package com.example.demo.Model;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Entity
@Data
public class user
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public user(String username, String password, String roles, String permissions)
    {
        this.username = username;
        this.password = password;
        this.blocked = 1;
        this.roles = roles;
        this.permissions = permissions;
    }
    public user(){}
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private int blocked;

    private String roles;

    private String permissions;

    public List<String> getRolesList()
    {
        if(this.roles.length()>0)
        {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList()
    {
        if(this.permissions.length()>0)
        {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
