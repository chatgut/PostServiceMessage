package com.example.webservice.postservicews.Controller;
import com.example.webservice.postservicews.Message;
import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.service.MessageService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:8080")
public class MessageController {


    private final MessageService messageService;
    private final MessageRepository messageRepository;

    public MessageController(MessageService messageService, MessageRepository messageRepository) {
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }


    @GetMapping("/posts")
    public List<MessageDTO> getAllMessages(@RequestHeader("userID") String from,
                                                           @RequestParam String to,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int nMessages) {
        /*Pageable paging = PageRequest.of(page, nMessages, Sort.by("date").descending());
        List<MessageDTO> fromAndTo = messageRepository.findMessages(from, to, paging).getContent();*/
        /*List<Message> fromandto = messageRepository.findByFromEqualsIgnoreCaseAndToEqualsIgnoreCase(
                from, to, paging).getContent();*/
       List<MessageDTO> messageDTOList = messageService.getAllMessages(from,to,page,nMessages);
        return messageDTOList;
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
    @PostMapping("/posts")
    public ResponseEntity<MessageDTO> addMessage(@RequestHeader("userID") String userID, @RequestBody NewMessageDTO newMessageDTO) {
       newMessageDTO.setFrom(userID);
        MessageDTO savedMessage = messageService.save(newMessageDTO);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }
}
