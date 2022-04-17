package com.example.application.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.application.Entity.AppUser;
import com.example.application.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//klassen används för att koppla mellan användare och databas
public class UserDetailsServiceImp implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    AppUserRepository appUserRepository;
    //hämta användare från databas
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=appUserRepository.findAppUserByUsername(username).orElseThrow();
        return new User(appUser.getUsername(),appUser.getPassword(), List.of());
    }
    public void save(AppUser appUser){

    }
}
