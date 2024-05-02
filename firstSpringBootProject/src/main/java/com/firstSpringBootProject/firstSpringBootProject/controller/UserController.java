package com.firstSpringBootProject.firstSpringBootProject.controller;

import com.firstSpringBootProject.firstSpringBootProject.dto.UserDto;
import com.firstSpringBootProject.firstSpringBootProject.entity.User;
import com.firstSpringBootProject.firstSpringBootProject.exception.ErrorDetails;
import com.firstSpringBootProject.firstSpringBootProject.exception.ResourceNotFoundException;
import com.firstSpringBootProject.firstSpringBootProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;


    //Build create User REST API
@PostMapping
    public ResponseEntity<UserDto> createUser (@RequestBody UserDto user)
    {
        UserDto savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
//build get User by id REST API
    //http://localhost:8080/api/users/1
@GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId)
    {
        UserDto user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
@GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        List<UserDto> users=userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@RequestBody UserDto user)
    {
        user.setId(userId);
       UserDto updatedUser= userService.updateUser(user);

       return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }
    //Build delete user REST API
@DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully deleted ",HttpStatus.OK);

    }
//@ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest){
//        ErrorDetails errorDetails=new ErrorDetails(
//                LocalDateTime.now(), exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//
//    }


}
