package com.projecthub.projecthub.controller;

import com.projecthub.projecthub.entities.UserEntity;
import com.projecthub.projecthub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<List<UserEntity>> getUsers() {
        var user = userService.getUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<UserEntity> addUsers(
            @RequestBody UserEntity user
    ) {
        var userResponse = userService.addUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
