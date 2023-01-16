package com.example.demo.data;

import com.example.demo.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDetailsData implements UserDetails {

    private final Optional<User> optionalUser;

    public UserDetailsData(Optional<User> optionalUser) {
        this.optionalUser = optionalUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return optionalUser.isEmpty() ? null : optionalUser.get().getPassword();
    }

    @Override
    public String getUsername() {
        return optionalUser.isEmpty() ? null : optionalUser.get().getLogin();
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
        return true;
    }

    //Todo: Change returns methods?

}
