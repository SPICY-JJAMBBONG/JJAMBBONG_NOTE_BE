package com.jjambbong.note.service;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.dto.BlockTextDto;
import com.jjambbong.note.entity.BlockText;

public interface BlockTextService {
	ApiResponse<String> createBlockText(BlockTextDto blockTextDto);
	BlockText getBlockText(String id);
	ApiResponse<String> updateBlockText(BlockTextDto blockTextDto, String id);
	ApiResponse<String> updateBlockText(BlockDto blockDto, String id);
	ApiResponse<String> deleteBlockText(String id);
}
