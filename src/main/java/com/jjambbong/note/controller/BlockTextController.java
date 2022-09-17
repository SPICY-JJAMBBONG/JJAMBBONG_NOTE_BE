package com.jjambbong.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.BlockTextDto;
import com.jjambbong.note.entity.BlockText;
import com.jjambbong.note.service.BlockTextService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlockTextController {

	@Autowired
	private final BlockTextService blockTextService;


	@PostMapping(path = "/api/block/text/create")
	public ApiResponse<String> createBlock(@RequestBody BlockTextDto blockTextDto) {
		return blockTextService.createBlockText(blockTextDto);
	}

	@GetMapping(path = "/api/block/text/{id}")
	public BlockText getBlock(@PathVariable String id) {
		return blockTextService.getBlockText(id);
	}

	@PutMapping(path = "/api/block/text/{id}")
	public ApiResponse<String> updateBlock(@PathVariable String id, @RequestBody BlockTextDto blockTextDto){
		return blockTextService.updateBlockText(blockTextDto, id);
	}

	@DeleteMapping(path = "/api/block/text/{id}")
	public ApiResponse<String> deleteBlock(@PathVariable String id){
		 return blockTextService.deleteBlockText(id);
	}
}
