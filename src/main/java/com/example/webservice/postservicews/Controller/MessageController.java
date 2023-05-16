package com.example.webservice.postservicews.Controller;
import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.service.MessageService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:8080")
public class MessageController {
    private final MessageService messageService;
    private final MessageRepository messageRepository;

    public MessageController(MessageService messageService, MessageRepository messageRepository) {
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> messageDTOList = messageService.getAllMessages();
        return ResponseEntity.ok(messageDTOList);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable String id) {
        boolean deleted = messageService.deleteMessage(id);
        if (deleted) {
        return ResponseEntity.ok().build();
    } else {
            return ResponseEntity.notFound().build();
        }
        }
    @PostMapping
    public ResponseEntity<MessageDTO> addMessage(@RequestBody NewMessageDTO newMessageDTO) {
        MessageDTO savedMessage = messageService.save(newMessageDTO);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }
}
