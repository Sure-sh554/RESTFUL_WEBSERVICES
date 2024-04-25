package com.firstSpringBootProject.firstSpringBootProject.service.impl;

import com.firstSpringBootProject.firstSpringBootProject.dto.UserDto;
import com.firstSpringBootProject.firstSpringBootProject.entity.User;
import com.firstSpringBootProject.firstSpringBootProject.mapper.UserMapper;
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
    public UserDto createUser(UserDto userDto) {

        //Convert userdto into user jpa entity
        User user= UserMapper.mapToUser(userDto);


        User savedUser= userRepository.save(user);

        //Convert userJpa entity to user dto

        UserDto savedUserDto=UserMapper.mapToUser(savedUser);

        return savedUserDto;

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

    @Override
    public User updateUser(User user) {
        User existingUser= userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
       User updateUser =userRepository.save(user);
        return updateUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
