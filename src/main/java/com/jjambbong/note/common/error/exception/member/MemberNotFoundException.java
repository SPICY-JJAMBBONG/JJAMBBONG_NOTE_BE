package com.jjambbong.note.common.error.exception.member;

import com.jjambbong.note.common.error.exception.EntityNotFoundException;

public class MemberNotFoundException extends EntityNotFoundException {

	public MemberNotFoundException(Long target) {
		super(target + " is not found");
	}
}
