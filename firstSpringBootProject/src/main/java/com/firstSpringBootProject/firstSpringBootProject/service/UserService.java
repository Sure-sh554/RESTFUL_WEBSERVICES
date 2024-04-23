package com.firstSpringBootProject.firstSpringBootProject.service;

import com.firstSpringBootProject.firstSpringBootProject.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById (Long userId);

    List<User> getAllUser();

}
