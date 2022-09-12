package com.jjambbong.note.common.error.exception.block;

import org.springframework.http.HttpStatus;

import com.jjambbong.note.common.error.exception.code.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BlockErrorCode implements ErrorCode {

	//DUPLICATED_BLOCK(HttpStatus.FOUND,"이미 존재하는 블록입니다."),
	UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR,"알 수 없는 에러가 발생하였습니다."),
	UNKNOWN_BLOCK(HttpStatus.NOT_FOUND,"존재하지 않는 블록입니다."),
	MISSDATA(HttpStatus.BAD_REQUEST, "데이터가 누락되었습니다."),
	NOTFITDATA(HttpStatus.BAD_REQUEST, "This data doesn't fit the type");

	private final HttpStatus httpStatus;
	private final String message;
}
