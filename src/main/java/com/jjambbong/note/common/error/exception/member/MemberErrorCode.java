package com.jjambbong.note.common.error.exception.member;

import org.springframework.http.HttpStatus;

import com.jjambbong.note.common.error.exception.code.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {

	DUPLICATED_USER(HttpStatus.FOUND,"이미 가입된 사용자입니다."),
	UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR,"알 수 없는 에러가 발생하였습니다."),
	UNKNOWN_USER(HttpStatus.NOT_FOUND,"가입되지 않은 사용자입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
