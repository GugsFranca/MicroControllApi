package com.micro.usersapi.infra;

import com.micro.usersapi.model.UserModel;
import com.micro.usersapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User was not found with username: " + username));

        return new User(userModel.getUsername(), userModel.getPassword(), userModel.getAuthorities());
    }
}
