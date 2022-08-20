package com.jjambbong.note.common.error.exception.blockPage;

import org.springframework.http.HttpStatus;

import com.jjambbong.note.common.error.exception.code.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BlockPageErrorCode implements ErrorCode {

	//DUPLICATED_BLOCK(HttpStatus.FOUND,"이미 존재하는 블록입니다."),
	UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR,"알 수 없는 에러가 발생하였습니다."),
	UNKNOWN_BLOCK(HttpStatus.NOT_FOUND,"존재하지 않는 블록입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
