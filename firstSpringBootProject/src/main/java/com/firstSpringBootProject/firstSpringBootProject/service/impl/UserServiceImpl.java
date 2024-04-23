package com.firstSpringBootProject.firstSpringBootProject.service.impl;

import com.firstSpringBootProject.firstSpringBootProject.entity.User;
import com.firstSpringBootProject.firstSpringBootProject.repository.UserRepository;
import com.firstSpringBootProject.firstSpringBootProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
       Optional<User> optionalUser= userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }
}
