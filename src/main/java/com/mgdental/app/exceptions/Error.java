package com.mgdental.app.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Error {
    LOGING_INFO_INVALID("Login information is invalid", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_NOT_FOUND("user not found", HttpStatus.NOT_FOUND),
    ROLE_NOT_FOUND("role not found", HttpStatus.NOT_FOUND),
    STATE_NOT_FOUND("state not found", HttpStatus.NOT_FOUND),
    MUNICIPALITY_NOT_FOUND("municipality not found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus status;
    Error(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }

}
