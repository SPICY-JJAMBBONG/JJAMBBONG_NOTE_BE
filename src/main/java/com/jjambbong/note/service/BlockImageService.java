package com.jjambbong.note.service;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.dto.BlockImageDto;
import com.jjambbong.note.entity.BlockImage;

public interface BlockImageService {
    BlockImage getBlockImage(String id);
    ApiResponse<String> createBlockImage(BlockDto blockDto);
    ApiResponse<String> updateBlockImage(BlockDto blockDto, String id);
    ApiResponse<String> deleteBlockImage(String id);

}
