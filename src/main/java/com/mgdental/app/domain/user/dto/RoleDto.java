package com.mgdental.app.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor
@Builder
@JsonTypeName("user")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class RoleDto {
    @NotNull
    private String name;

    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonTypeName("role")
    public static class Insert {
        private String userName;
        private String roleName;
    }
}
