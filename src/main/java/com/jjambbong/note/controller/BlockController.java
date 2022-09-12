package com.jjambbong.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.entity.Block;
import com.jjambbong.note.service.BlockService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlockController {

	@Autowired
	private final BlockService blockService;


	@PostMapping(path = "/api/block/create")
	public ApiResponse<String> createBlock(BlockDto blockDto) {
		return blockService.createBlock(blockDto);
	}

	@GetMapping(path = "/api/block/{id}")
	public Block getBlock(@PathVariable String id) {
		return blockService.getBlock(id);
	}

	@PutMapping(path = "/api/block/{id}")
	public ApiResponse<String> updateBlock(@PathVariable String id, BlockDto blockDto){
		return blockService.updateBlock(blockDto, id);
	}

	@DeleteMapping(path = "/api/block/{id}")
	public ApiResponse<String> deleteBlock(@PathVariable String id){
		 return blockService.deleteBlock(id);
	}
}
