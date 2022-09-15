package com.jjambbong.note.error.exception;

import com.jjambbong.note.error.ErrorCode;

public class MemberNotFoundException extends BusinessException{
    public MemberNotFoundException(ErrorCode errorCode) {
        super(ErrorCode.MEMBER_NOT_FOUND.getMessage(), ErrorCode.MEMBER_NOT_FOUND);
    }
}
