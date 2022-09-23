package com.jjambbong.note.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.service.BlockPageService;
import com.jjambbong.note.service.BlockTextService;
import com.mongodb.Block;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlockPageController {

	@Autowired
	private final BlockPageService blockPageService;
	@Autowired
	private final BlockTextService blockTextService;


	@PostMapping(path = "/api/block/page/create")
	public ApiResponse<String> createBlock(@RequestBody BlockPageDto blockPageDto) {
		return blockPageService.createBlockPage(blockPageDto);
	}

	@GetMapping(path = "/api/block/page/{id}")
	public BlockPage getBlock(@PathVariable String id) {
		return blockPageService.getBlockPage(id);
	}

	@GetMapping(path = "/api/blcok/page/{id}/all")
	public HashMap<String, Map> getBlockAll(@PathVariable String id){

		// List<String> blockDetailList = new ArrayList<String>();
		HashMap<String, Map> blockDetailList = new HashMap<>();

		BlockPage blockPage = blockPageService.getBlockPage(id);

		for(String blockId : blockPage.getBlockList()){
			if(blockId.contains("page")) //blockList에 page가 있다면
				// blockDetailList.add(blockPageService.getBlockPage(id).toString());
				blockDetailList.put(blockId, blockPageService.getBlockPage(blockId).toHashMap());
			else
				// blockDetailList.add(blockTextService.getBlockText(id).toString());
				blockDetailList.put(blockId, blockTextService.getBlockText(id).toHashMap());
		}

		return blockDetailList;
	}

	@PutMapping(path = "/api/block/page/{id}")
	public ApiResponse<String> updateBlock(@PathVariable String id, @RequestBody BlockPageDto blockPageDto){
		return blockPageService.updateBlockPage(blockPageDto, id);
	}

	@DeleteMapping(path = "/api/block/page/{id}")
	public ApiResponse<String> deleteBlock(@PathVariable String id){
		 return blockPageService.deleteBlockPage(id);
	}
}
