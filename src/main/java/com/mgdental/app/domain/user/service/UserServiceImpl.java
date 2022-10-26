package com.mgdental.app.domain.user.service;

import com.mgdental.app.domain.user.dto.RoleDto;
import com.mgdental.app.domain.user.dto.UserDto;
import com.mgdental.app.domain.user.entity.Role;
import com.mgdental.app.domain.user.entity.User;
import com.mgdental.app.domain.user.mapper.UserMapper;
import com.mgdental.app.domain.user.repository.RoleRepository;
import com.mgdental.app.domain.user.repository.UserRepository;
import com.mgdental.app.exceptions.AppException;
import com.mgdental.app.exceptions.Error;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<UserDto> saveUser(UserDto.Insert registration) {
        return ResponseEntity.ok(insertUser(registration));
    }

    @Override
    public ResponseEntity<UserDto> login(UserDto.Login login) {
        return ResponseEntity.ok(UserMapper.mapUserToDto(
                userRepository.findByEmail(login.getEmail())
                .filter(user -> passwordEncoder.matches(login.getPassword(), user.getPassword()))
                .orElseThrow(() -> new AppException(Error.LOGING_INFO_INVALID))
        ));
    }

    @Override
    public ResponseEntity<UserDto> findBYName(String username) {
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isEmpty())
            throw new AppException(Error.USER_NOT_FOUND);
        return ResponseEntity.ok(UserMapper.mapUserToDto(user.get()));
    }

    @Override
    public ResponseEntity<UserDto> findBYId(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new AppException(Error.USER_NOT_FOUND);
        return ResponseEntity.ok(UserMapper.mapUserToDto(user.get()));
    }

    private UserDto insertUser(UserDto.Insert registration){
        User user = User.builder()
                .userName(registration.getName())
                .email(registration.getEmail())
                .idSpeciality(registration.getIdSpeciality())
                .activo(registration.getActivo())
                .password(passwordEncoder.encode(registration.getPassword()))
                .build();
        return UserMapper.mapUserToDto(userRepository.save(user));
    }

    @Override
    public ResponseEntity<Role> saveRole(Role role) {
        return ResponseEntity.status(200).body(roleRepository.save(role));
    }

    @Override
    public void addRoleToUser(RoleDto.Insert insertRole) {
        Optional<User> user = userRepository.findByUserName(insertRole.getUserName());
        Optional<Role> role = roleRepository.findByName(insertRole.getRoleName());
        if(user.isEmpty())
            throw new AppException(Error.USER_NOT_FOUND);

        if (role.isEmpty())
            throw new AppException(Error.ROLE_NOT_FOUND);

        user.get().getRoles().add(role.get());

        userRepository.save(user.get());
    }

}
