package com.example.taskmanager.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public class UserPrinciple implements UserDetails {
    User user;
    public UserPrinciple(User user) {
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Always non-expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Always non-locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Always non-expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Always enabled
    }

}
