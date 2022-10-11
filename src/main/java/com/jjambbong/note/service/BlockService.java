package com.jjambbong.note.service;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.entity.Block;

public interface BlockService {
	ApiResponse<String> createBlock(BlockDto blockDto);
	Block getBlock(String id);
	ApiResponse<String> updateBlock(BlockDto blockDto, String id);
	ApiResponse<String> deleteBlock(String id);
}
