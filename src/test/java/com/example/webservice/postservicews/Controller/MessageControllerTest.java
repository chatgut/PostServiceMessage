package com.example.webservice.postservicews.Controller;

import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class MessageControllerTest {
    private MessageController messageController;
    @Captor
    private ArgumentCaptor<NewMessageDTO> newMessageDTOCaptor;
    @Captor
    private ArgumentCaptor<Integer> pageCaptor;
    @Captor
    private ArgumentCaptor<String> fromCaptor;
    @Captor
    private ArgumentCaptor<String> toCaptor;
    @Captor
    private ArgumentCaptor<Integer> nMessagesCaptor;
    @Mock
    private MessageService messageService;
    @Mock
    private MessageRepository messageRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        messageController = new MessageController(messageService, messageRepository);
    }

    @Test
    void deleteMessageToCheckIfNotFoundIsReturned() {
        String id = "1";
        when(messageService.deleteMessage(id)).thenReturn(false);
        ResponseEntity<?> responseEntity = messageController.deleteMessage(id);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(messageService, times(1)).deleteMessage(id);
    }

    @Test
    void addMessageToCheckIfSaved() {
        String userID = "user1";
        NewMessageDTO newMessageDTO = new NewMessageDTO();
        MessageDTO savedMessage = new MessageDTO();
        doReturn(savedMessage).when(messageService).save(newMessageDTOCaptor.capture());
        ResponseEntity<MessageDTO> responseEntity = messageController.addMessage(userID, newMessageDTO);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(savedMessage, responseEntity.getBody());
        assertEquals(newMessageDTO, newMessageDTOCaptor.getValue());
    }

    @Test
    void returnListOfAllMessages() {
        String from = "user1";
        String to = "user2";
        int page = 0;
        int nMessages = 10;
        List<MessageDTO> expectedMessages = Arrays.asList(
                new MessageDTO(),
                new MessageDTO()
        );
        doReturn(expectedMessages).when(messageService).getAllMessages(fromCaptor.capture(), toCaptor.capture(), pageCaptor.capture(), nMessagesCaptor.capture());

        List<MessageDTO> actualMessages = messageController.getAllMessages(from, to, page, nMessages);
        assertEquals(expectedMessages, actualMessages);

        assertEquals(from, fromCaptor.getValue());
        assertEquals(to, toCaptor.getValue());
        assertEquals(page, pageCaptor.getValue());
        assertEquals(nMessages, nMessagesCaptor.getValue());
    }
}