package com.jjambbong.note.common.error.exception.member;

import com.jjambbong.note.common.error.exception.BusinessException;

public class MemberNotFoundException extends BusinessException {

	public MemberNotFoundException(Long target) {
		super(MemberErrorCode.UNKNOWN_USER,target + " is not found");
	}
}
