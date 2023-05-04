package com.example.webservice.postservicews.Controller;

import com.example.webservice.postservicews.service.MessageService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public void postMessage(@RequestBody Message message) {
        messageService.saveMessage(message);
    }

    @GetMapping("/messages")
    public List<Message> getMessages(@RequestParam String toUserId, @RequestParam String fromUserId) {
        return messageService.getMessages(toUserId, fromUserId);
    }

}
