package com.jjambbong.note.controller;

import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.service.BlockPageWService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private BlockPageWService blockPageWService;

	// TODO: command, header, body 쓰는 방법 찾아서 적용하기
	@MessageMapping("/block/{page_id}")
	public void updateBlock(@DestinationVariable("page_id") Long pageId, BlockDto blockDto) throws Exception {
		template.convertAndSend("/sub/block/" + pageId, blockDto);
		System.out.println("blockDto = " + blockDto);
		blockPageWService.transferBlockToMap(blockDto);
	}


	public void createBlockService(BlockDto blockDto) throws InterruptedException {
		Thread.sleep(100);
	}
}

