package com.jjambbong.note.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.entity.BlockPage;

@Service
public interface BlockPageService {

	public ApiResponse<String> createBlockPage(BlockPage blockPage);

	Optional<BlockPage> findById(String id);

	ApiResponse updateBlockPage(BlockPageDto blockPageDto, String blockId);

	ApiResponse deleteBlockPage(String blockId);
}
