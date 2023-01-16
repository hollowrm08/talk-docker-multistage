package com.example.demo.service;

import com.example.demo.data.UserDetailsData;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceTest {

    @InjectMocks
    UserDetailsService tested;

    @Mock
    private UserRepository userRepository;

    @Test
    public void loadShouldReturnUserDetails(){
        UserDetails userDetails = mockUserDetails();
        Mockito.when(userRepository.findByLogin("login"))
            .thenReturn(mockOptionalUser());

        UserDetails result = tested.loadUserByUsername("login");

        Mockito.verify(userRepository).findByLogin("login");

        Assert.assertNotNull(result);
        Assert.assertEquals(userDetails.getUsername(), result.getUsername());
        Assert.assertEquals(userDetails.getPassword(), result.getPassword());
        Assert.assertEquals(userDetails.getAuthorities(), result.getAuthorities());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadMustThrowUsernameNotFoundException() {
        Mockito.when(userRepository.findByLogin("invalidLogin"))
            .thenReturn(Optional.empty());

        tested.loadUserByUsername("invalidLogin");
    }

    private Optional<User> mockOptionalUser(){
        User user = new User();
        user.setLogin("login");
        user.setPassword("genericPassword");
        return Optional.of(user);
    }

    private UserDetails mockUserDetails(){
        return new UserDetailsData(mockOptionalUser());
    }

}