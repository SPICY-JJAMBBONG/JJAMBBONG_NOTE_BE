package com.jjambbong.note.common.error.exception;

import com.jjambbong.note.common.error.exception.code.CommonErrorCode;
import com.jjambbong.note.common.error.exception.code.ErrorCode;

public class EntityNotFoundException extends BusinessException {

	public EntityNotFoundException(String message) {
		super(CommonErrorCode.ENTITY_NOT_FOUND, message);
	}
}
