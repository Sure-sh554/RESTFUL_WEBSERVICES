package com.firstSpringBootProject.firstSpringBootProject.mapper;

import com.firstSpringBootProject.firstSpringBootProject.dto.UserDto;
import com.firstSpringBootProject.firstSpringBootProject.entity.User;

public class UserMapper {
//Convert User JPA Entity to UserDto
    public static UserDto mapToUser(User user)
    {
        UserDto userDto=new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDto;
    }

    //Convert UserDto into User JPA Entity

    public static User mapToUser(UserDto userDto)
    {
        User user=new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
