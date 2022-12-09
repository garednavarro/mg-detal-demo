package com.mgdental.app.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mgdental.app.domain.user.entity.Role;
import com.mgdental.app.domain.user.entity.Speciality;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
@Builder
@JsonTypeName("user")
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class UserDto {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private Speciality speciality;
    @NotNull
    private Long phoneNumber;
    @NonNull
    private Boolean activo;

    private Set<Role> roles;

    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonTypeName("user")
    public static class Insert {
        private String name;
        private String email;
        private String password;
        private Speciality speciality;
        private Set<Role> roles;
        private Long phone;
        private Boolean activo;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @JsonTypeName("user")
    public static class Login {
        @NotNull
        @Email
        private String email;

        @NotBlank
        private String password;
    }
}
