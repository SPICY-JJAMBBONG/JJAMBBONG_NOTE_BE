package com.jjambbong.note.common.error.exception.code;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

	DUPLICATED_USER(HttpStatus.FOUND,"이미 가입된 사용자입니다."),
	UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR,"알 수 없는 에러가 발생하였습니다."),
	UNKNOWN_USER(HttpStatus.NOT_FOUND,"가입되지 않은 사용자입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
