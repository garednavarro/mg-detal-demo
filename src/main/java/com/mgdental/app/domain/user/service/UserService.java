package com.mgdental.app.domain.user.service;

import com.mgdental.app.domain.user.dto.RoleDto;
import com.mgdental.app.domain.user.dto.UserDto;
import com.mgdental.app.domain.user.entity.Role;
import com.mgdental.app.domain.user.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<UserDto> saveUser(final UserDto.Insert registration);

    ResponseEntity<UserDto> login(final UserDto.Login login);

    ResponseEntity<UserDto> findBYName(String username);

    ResponseEntity<UserDto> findBYId(Integer id);

    ResponseEntity<Role> saveRole(Role role);

    void addRoleToUser(RoleDto.Insert insertRole);

}
