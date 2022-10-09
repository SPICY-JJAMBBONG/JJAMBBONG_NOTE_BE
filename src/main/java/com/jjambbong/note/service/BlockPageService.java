package com.jjambbong.note.service;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.entity.BlockPage;

public interface BlockPageService {
	ApiResponse<String> createBlockPage(BlockPageDto blockPageDto);
	BlockPage getBlockPage(String id);
	ApiResponse<String> updateBlockPage(BlockPageDto blockPageDto, String id);
	ApiResponse<String> updateBlockPage(BlockDto blockDto, String id);
	ApiResponse<String> deleteBlockPage(String id);
}
