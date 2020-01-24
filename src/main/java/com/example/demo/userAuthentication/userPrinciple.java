package com.example.demo.userAuthentication;

import com.example.demo.Model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class userPrinciple implements UserDetails
{

    @Autowired
    private user myUser;

    public userPrinciple(user myUser) {
        this.myUser=myUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list=new ArrayList<>();

        // get the list of permissions
        this.myUser.getPermissionList().forEach(p->
        {
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(p);
            list.add(grantedAuthority);
        });

        // get The list of roles
        this.myUser.getRolesList().forEach(p->
        {
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("ROLE_"+p);
            list.add(grantedAuthority);
        });
        return list;
    }

    @Override
    public String getPassword() {
        return this.myUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.myUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.myUser.getBlocked()==1;
    }
}
