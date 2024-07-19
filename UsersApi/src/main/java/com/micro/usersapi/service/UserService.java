package com.micro.usersapi.service;

import com.micro.usersapi.model.RoleModel;
import com.micro.usersapi.model.UserModel;
import com.micro.usersapi.repository.RoleRepository;
import com.micro.usersapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    RoleRepository roleRepository;
    public List<UserModel> getUsers(){
        return repository.findAll();
    }
    public Optional<UserModel> getOneUserById(UUID id){
        return repository.findById(id);
    }
    public Optional<UserModel> getOneUserByName(String username){
        return repository.findByUsername(username);
    }
    public void deleteByID(UUID id){
        repository.deleteById(id);
    }
    public UserModel createUser(UserModel userModel) {
        List<RoleModel> roleModel = new ArrayList<>();

        for (RoleModel roles : userModel.getRole()) {
            RoleModel existingRole = roleRepository.findByRoleName(roles.getRoleName());
            if (existingRole != null) {
                roleModel.add(existingRole);
            } else roleModel.add(roleRepository.save(roles));
        }

        userModel.setRole(roleModel);
        userModel.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));


        return repository.save(userModel);
    }
}
