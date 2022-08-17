package com.jjambbong.note.common.error.exception.code;

import org.springframework.http.HttpStatus;

import com.jjambbong.note.common.ResponseCode;

public interface ErrorCode {
	String name();
	HttpStatus getHttpStatus();
	String getMessage();
}
