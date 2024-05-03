package com.firstSpringBootProject.firstSpringBootProject.controller;

import com.firstSpringBootProject.firstSpringBootProject.dto.UserDto;
import com.firstSpringBootProject.firstSpringBootProject.entity.User;
import com.firstSpringBootProject.firstSpringBootProject.exception.ErrorDetails;
import com.firstSpringBootProject.firstSpringBootProject.exception.ResourceNotFoundException;
import com.firstSpringBootProject.firstSpringBootProject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs-Create User,Update User, Get User, Get All User, Delete User "
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;


@Operation(
        summary = "Create User REST API ",
        description = "Create User REST API is used to save user in a database"
)
@ApiResponse(
        responseCode = "201",
        description = "HTTP Status Code Created"
)
//Build create User REST API
@PostMapping
    public ResponseEntity<UserDto> createUser (@Valid @RequestBody UserDto user)
    {
        UserDto savedUser=userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
//build get User by id REST API
    //http://localhost:8080/api/users/1
@Operation(
        summary = "Get User By ID REST API ",
        description = "Get User By ID REST API is used to get single user from the database"
)
@ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS"
)
@GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId)
    {
        UserDto user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Users By ID REST API ",
            description = "Get All Users By ID REST API is used to get all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
@GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        List<UserDto> users=userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //http://localhost:8080/api/users/1
    @Operation(
            summary = "Update User  REST API ",
            description = "Update REST API is used to update a particular user in  the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,@Valid@RequestBody UserDto user)
    {
        user.setId(userId);
       UserDto updatedUser= userService.updateUser(user);

       return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }
    //Build delete user REST API
    @Operation(
            summary = "Delete User REST API ",
            description = "Delete User  REST API is used to delete the user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
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
