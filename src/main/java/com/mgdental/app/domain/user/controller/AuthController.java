package com.mgdental.app.domain.user.controller;

import com.mgdental.app.domain.user.dto.UserDto;
import com.mgdental.app.domain.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AuthController {

    private final UserServiceImpl userService;

    @PostMapping("/add-user")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto.Insert user){
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUsers(@RequestBody UserDto.Login login){
        return userService.login(login);
    }

}
