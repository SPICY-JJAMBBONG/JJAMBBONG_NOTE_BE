package com.jjambbong.note.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.service.BlockPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlockPageController {

	@Autowired
	private final BlockPageService blockPageService;

	@PostMapping(path = "/api/block-page/create")
	public ApiResponse<String> createBlockPage(BlockPageDto blockPageDto) {
		BlockPage blockPage = BlockPage.builder()
			.id(blockPageDto.getId())
			.order(blockPageDto.getOrder()).build();

		return blockPageService.createBlockPage(blockPage);
	}

	@GetMapping(path = "/api/block-page/{blockId}")
	public Optional<BlockPage> findBlockPageById(@PathVariable String blockId) {
		Optional<BlockPage> blockPage = blockPageService.findById(blockId);

		return blockPage;
	}

	@PutMapping(path = "/api/block-page/{blockId}")
	public ApiResponse<String> updateBlockPage(@PathVariable String blockId, BlockPageDto blockPageDto){
		ApiResponse apiResponse = blockPageService.updateBlockPage(blockPageDto, blockId);
		return apiResponse;
	}

	@DeleteMapping(path = "/api/block-page/{blockId}")
	public ApiResponse<String> deleteBlockPage(@PathVariable String blockId){
		ApiResponse apiResponse = blockPageService.deleteBlockPage(blockId);
		return apiResponse;
	}
}
