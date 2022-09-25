package com.jjambbong.note.controller;

import com.jjambbong.note.entity.Document;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping("/send/test")
	@SendTo("/topic/receive/test")
	public Document test(String content) throws Exception {
		Document document = new Document(content);
		System.out.println("document = " + document);
		System.out.println("document = " + document);
		return document;
	}
}
