package com.jjambbong.note.common.error.exception.code;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{

	INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid parameter included"),
	RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not exists"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
	INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "INVALID_TYPE_VALUE"),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "METHOD_NOT_ALLOWED"),
	HANDLE_ACCESS_DENIED(HttpStatus.INTERNAL_SERVER_ERROR, "HANDLE_ACCESS_DENIED"),
	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "INVALID_TYPE_VALUE"),
	ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "ENTITY NOT FOUND");

	private final HttpStatus httpStatus;
	private final String message;
}
