package com.jjambbong.note.common.error.exception.blockPage;

import com.jjambbong.note.common.error.exception.BusinessException;
import com.jjambbong.note.common.error.exception.member.MemberErrorCode;

public class BlockPageNotFoundException extends BusinessException {

	public BlockPageNotFoundException(String target) {
		super(BlockPageErrorCode.UNKNOWN_BLOCK,target + " is not found");
	}
}
