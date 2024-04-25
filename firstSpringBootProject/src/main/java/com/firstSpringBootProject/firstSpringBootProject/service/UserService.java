package com.firstSpringBootProject.firstSpringBootProject.service;

import com.firstSpringBootProject.firstSpringBootProject.dto.UserDto;
import com.firstSpringBootProject.firstSpringBootProject.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    User getUserById (Long userId);

    List<User> getAllUser();

    User updateUser(User user);

    void deleteUser(Long userId);

}
