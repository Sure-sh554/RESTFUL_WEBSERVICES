package com.firstSpringBootProject.firstSpringBootProject.service.impl;

import com.firstSpringBootProject.firstSpringBootProject.entity.User;
import com.firstSpringBootProject.firstSpringBootProject.repository.UserRepository;
import com.firstSpringBootProject.firstSpringBootProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
