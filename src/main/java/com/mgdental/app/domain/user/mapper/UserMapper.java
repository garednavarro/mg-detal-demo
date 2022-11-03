package com.mgdental.app.domain.user.mapper;

import com.mgdental.app.domain.user.dto.UserDto;
import com.mgdental.app.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User mapUserToEntity(UserDto.Insert userDto){
        return User.builder()
                .userName(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .speciality(userDto.getIdSpeciality())
                .phoneNumber(userDto.getPhone())
                .activo(userDto.getActivo())
                .build();
    }

    public static UserDto mapUserToDto(User user){
        return UserDto.builder()
                .username(user.getUserName())
                .email(user.getEmail())
                .speciality(user.getSpeciality())
                .phoneNumber(user.getPhoneNumber())
                .activo(user.getActivo())
                .roles(user.getRoles())
                .build();
    }
}
