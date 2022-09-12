package com.jjambbong.note.common.error.exception.block;

import com.jjambbong.note.common.error.exception.BusinessException;

public class BlockNotFoundException extends BusinessException {

	public BlockNotFoundException(String target) {
		super(BlockErrorCode.UNKNOWN_BLOCK,target + " is not found");
	}
}
