package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.Message;
import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.exception.MessageNotFoundException;
import com.example.webservice.postservicews.repository.MessageRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceImplTest {

    @Mock
    private MessageRepository messageRepository;

    private MessageServiceImpl messageService;

    @Before("")
    public void setup() {
        MockitoAnnotations.initMocks(this);
        messageService = new MessageServiceImpl(messageRepository);
    }
    @Test
    void testSaveMessage() {
        // Create a new message
        Message newMessage = new Message();
        newMessage.setText("Hello world");
        newMessage.setUserID("user1");
        newMessage.setReceiver("user2");

        // Save the message
        MessageDTO savedMessage = messageService.save(newMessage);

        // Check that the saved message has an ID
        assertNotNull(savedMessage.getId());
    }

    @Test
    void testDeleteMessage() {
        // Create a new instance of the MessageServiceImpl class
        MessageServiceImpl messageService = new MessageServiceImpl(messageRepository);

        // Create a new message
        Message newMessage = new Message();
        newMessage.setText("Hello world");
        newMessage.setUserID("user1");
        newMessage.setReceiver("user2");

        // Save the message
        MessageDTO savedMessage = messageService.save(newMessage);

        // Delete the message
        messageService.deleteMessage(savedMessage.getId());

        // Check that the message was deleted
        assertThrows(MessageNotFoundException.class, () -> messageService.findById(savedMessage.getId()));
    }
}