package com.jjambbong.note.controller;

import com.jjambbong.note.entity.Document;
import com.mongodb.Block;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping("/send/test")
	@SendTo("/topic/receive/test")
	public Block test(String content) throws Exception {
//		Block block = new Block
//		Block document = new Document(content);
		return document;
	}
}
