package com.jjambbong.note.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ApiResponse<String> createBlock(@RequestBody BlockDto blockDto) {
		return blockService.createBlock(blockDto);
	}

	@GetMapping(path = "/api/block/{id}")
	public Block getBlock(@PathVariable String id) {
		return blockService.getBlock(id);
	}

	@GetMapping(path = "/api/block/{id}/all")
	public Map<String, Block> getBlockAll(@PathVariable String id){

		// List<String> blockDetailList = new ArrayList<String>();
		Map<String, Block> blockDetailList = new HashMap<>();

		Block block = blockService.getBlock(id);

		blockDetailList.put("pageInfo", block);

		if(!block.getType().equals("page"))
			throw new RuntimeException("Type data is not correct");

		for(String blockId : block.getBlockList()){
			blockDetailList.put(blockId, blockService.getBlock(blockId));
		}

		return blockDetailList;
	}

	@PutMapping(path = "/api/block/{id}")
	public ApiResponse<String> updateBlock(@PathVariable String id, @RequestBody BlockDto blockDto){
		return blockService.updateBlock(blockDto, id);
	}

	@DeleteMapping(path = "/api/block/{id}")
	public ApiResponse<String> deleteBlock(@PathVariable String id){
		 return blockService.deleteBlock(id);
	}
}
