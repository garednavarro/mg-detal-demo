package com.mgdental.app.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mgdental.app.domain.user.entity.Role;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@ToString
@AllArgsConstructor
@Builder
@JsonTypeName("user")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class UserDto {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private Integer idSpeciality;
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
        private Integer idSpeciality;
        private Long phone;
        private Boolean activo;
    }
}
