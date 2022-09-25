package com.jjambbong.note.controller;

import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.dto.BlockTextDto;
import com.jjambbong.note.entity.Document;
import com.jjambbong.note.service.BlockPageWService;
import com.mongodb.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private BlockPageWService blockPageWService;

	@MessageMapping("/block/{page_id}")
	public void updateBlock(@DestinationVariable("page_id") Long pageId, BlockDto blockDto) throws Exception {
		template.convertAndSend("/sub/block/" + pageId, blockDto);
		System.out.println("blockDto = " + blockDto);
		blockPageWService.transferBlockToMap(blockDto);
	}


//	@MessageMapping("/block/{block_id}/delete")
//
//
//	@MessageMapping("/block/<page_id>/reorder")


	public void createBlockService(BlockPageDto blockPageDto) throws InterruptedException {
		Thread.sleep(100);
	}
}

