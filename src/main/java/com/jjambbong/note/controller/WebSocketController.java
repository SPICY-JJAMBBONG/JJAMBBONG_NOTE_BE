package com.jjambbong.note.controller;

import com.jjambbong.note.entity.Document;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/topic/send")
    @SendTo("/topic/receive")
    public Document test(String content) throws Exception {
        System.out.println("received");
        return new Document(content);
    }
}
