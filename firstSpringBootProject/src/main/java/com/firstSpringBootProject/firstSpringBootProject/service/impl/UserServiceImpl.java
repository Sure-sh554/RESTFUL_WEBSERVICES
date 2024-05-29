package com.firstSpringBootProject.firstSpringBootProject.service.impl;

import com.firstSpringBootProject.firstSpringBootProject.dto.UserDto;
import com.firstSpringBootProject.firstSpringBootProject.entity.User;
import com.firstSpringBootProject.firstSpringBootProject.exception.EmailAlreadyExistException;
import com.firstSpringBootProject.firstSpringBootProject.exception.ResourceNotFoundException;
import com.firstSpringBootProject.firstSpringBootProject.mapper.AutoUserMapper;
import com.firstSpringBootProject.firstSpringBootProject.mapper.UserMapper;
import com.firstSpringBootProject.firstSpringBootProject.repository.UserRepository;
import com.firstSpringBootProject.firstSpringBootProject.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert userdto into user jpa entity
       // User user= UserMapper.mapToUser(userDto);

//        User user= modelMapper.map(userDto,User.class);

        Optional<User> optionalUser=userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw  new EmailAlreadyExistException("Email Already Exist for User");
        }

        User user= AutoUserMapper.MAPPER.mapToUser(userDto);


        User savedUser= userRepository.save(user);

        //Convert userJpa entity to user dto

       // UserDto savedUserDto=UserMapper.mapToUserDto(savedUser);

//        UserDto savedUserDto=modelMapper.map(savedUser,UserDto.class);

        UserDto savedUserDto=AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return savedUserDto;

    }

    @Override
    public UserDto getUserById(Long userId) {
      User user= userRepository.findById(userId).orElseThrow(
              () -> new ResourceNotFoundException("User","id",userId)
      );

        //return UserMapper.mapToUserDto(user);

//        return modelMapper.map(user,UserDto.class);

        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

        List<User> users= userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());
//        return users.stream().map((user -> modelMapper.map(user,UserDto.class)))
//                .collect(Collectors.toList());

        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser= userRepository.findById(user.getId()).orElseThrow(
                () ->new ResourceNotFoundException("User","id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
       User updateUser =userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(updateUser);
//        return modelMapper.map(updateUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser= userRepository.findById(userId).orElseThrow(
                () ->new ResourceNotFoundException("User","id", userId)
        );
        userRepository.deleteById(userId);
    }

    Set<Character> characterSet=new HashSet<>();
}
