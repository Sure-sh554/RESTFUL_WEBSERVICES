package com.firstSpringBootProject.firstSpringBootProject.controller;

import com.firstSpringBootProject.firstSpringBootProject.entity.User;
import com.firstSpringBootProject.firstSpringBootProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;


    //Build create User REST API
@PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user)
    {
        User savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
//build get User by id REST API
    //http://localhost:8080/api/users/1
@GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId)
    {
        User user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
@GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users=userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
