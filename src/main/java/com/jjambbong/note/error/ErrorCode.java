package com.jjambbong.note.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),


    // Member
    MEMBER_NOT_FOUND(400, "M001", "Member not found"),
    EMAIL_DUPLICATION(400, "M002", "Email is Duplication"),
    LOGIN_INPUT_INVALID(400, "M003", "Login input is invalid"),


    ;
    private int status;
    private final String code;
    private final String message;
}
