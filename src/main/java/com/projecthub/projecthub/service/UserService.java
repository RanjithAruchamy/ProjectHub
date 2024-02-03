package com.projecthub.projecthub.service;

import com.projecthub.projecthub.entities.UserEntity;
import com.projecthub.projecthub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity addUser(UserEntity users) {
        return userRepository.save(users);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
