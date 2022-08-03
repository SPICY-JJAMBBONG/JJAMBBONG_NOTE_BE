package com.jjambbong.note.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResponseCode {
	SUCCESS("성공"),
	DUPLICATED_USER("이미 가입된 사용자입니다."),
	UNKNOWN("알 수 없는 에러가 발생하였습니다."),
	UNKNOWN_USER("가입되지 않은 사용자입니다.");

	private final String message;
}
