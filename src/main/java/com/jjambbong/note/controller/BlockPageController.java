package com.jjambbong.note.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.service.BlockPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlockPageController {

	@Autowired
	private final BlockPageService blockPageService;

	@PostMapping(path = "/api/block-page")
	public String createBlockPage(String blockList,
		@RequestParam(value = "currentPageId", required = false) String currentPageId) {
		BlockPage blockPage = BlockPage.builder().blockId(UUID.randomUUID()).blockList(blockList).build();

		UUID uuid = blockPageService.createBlockPage(blockPage, currentPageId);

		return String.valueOf(uuid);
	}

	@GetMapping(path = "/api/block-page/{id}")
	public Optional<BlockPage> findBlockPageById(@PathVariable(name = "id") String id) {
		Optional<BlockPage> blockPageList = blockPageService.findById(id);

		return blockPageList;
	}

}
