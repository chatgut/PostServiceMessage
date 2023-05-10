package com.example.webservice.postservicews.Controller;

import com.example.webservice.postservicews.Message;
import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;
    private final MessageRepository messageRepository;

    public MessageController(MessageService messageService, MessageRepository messageRepository) {
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    @GetMapping
    List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @PostMapping
    void addMessage(@RequestBody MessageDTO messageDTO) {
        Message message = new Message();
        message.setSender(messageDTO.getSender());
        message.setReceiver(messageDTO.getReceiver());
        message.setText(messageDTO.getText());
        message.setDatetime(LocalDateTime.now());
        messageRepository.save(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }



/*    @PostMapping
    public ResponseEntity<MessageDTO> createPost(@Valid @RequestBody NewMessageDTO newMessageDTO) {
        MessageDTO savedMessage = messageService.save(newMessageDTO);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MessageDTO> getPostById(@PathVariable String id) {
        MessageDTO messageDTO = messageService.findById(id);
        return new ResponseEntity<>(messageDTO, HttpStatus.OK);
    }*/

}
