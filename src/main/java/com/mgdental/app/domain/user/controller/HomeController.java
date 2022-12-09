package com.mgdental.app.domain.user.controller;

import com.mgdental.app.domain.user.dto.RoleDto;
import com.mgdental.app.domain.user.dto.UserDto;
import com.mgdental.app.domain.user.entity.Role;
import com.mgdental.app.domain.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class HomeController {

    private UserServiceImpl userService;

    @PostMapping("/insertRole")
    public ResponseEntity<Role> insertRole(@RequestBody Role role) {
        log.info("INSIDE insertRole CONTROLLER!!! --> " + role.toString());
        return userService.saveRole(role);
    }

    @PutMapping("/addRoleToUser")
    public ResponseEntity<String> addRoleToUser(@RequestBody RoleDto.Insert insertRole) {
        userService.addRoleToUser(insertRole);
        return ResponseEntity.status(200).body("Role added");
    }

    @GetMapping("/getUser/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username){
        return userService.findBYName(username);
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from MG Dental";
    }

    @GetMapping("/manager")
    public String managerPage(){
        return "Thi is manager page";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "Thi is admin page";
    }

    @GetMapping("/user")
    public String userPage(){
        return "Thi is user page";
    }
}
