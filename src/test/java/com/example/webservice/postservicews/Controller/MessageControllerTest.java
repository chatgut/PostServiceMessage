package com.example.webservice.postservicews.Controller;

import com.example.webservice.postservicews.dto.MessageDTO;
import com.example.webservice.postservicews.dto.NewMessageDTO;
import com.example.webservice.postservicews.repository.MessageRepository;
import com.example.webservice.postservicews.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class MessageControllerTest {

    @Autowired
    MessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageRepository repository;

    @Test
    void getAllMessages() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/messages")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteMessage() throws Exception {
        // Create a new message
        NewMessageDTO newMessageDTO = new NewMessageDTO();
        newMessageDTO.setText("Hello");
        newMessageDTO.setUserID("tester1");
        newMessageDTO.setReceiver("tester2");
        MessageDTO savedMessage = messageService.save(newMessageDTO);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/messages/{id}", savedMessage.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/messages/{id}", savedMessage.getId()))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    void addMessageAndCheckIfStatus201isReturned() throws Exception {
        String requestBody = "{\"text\": \"Goddag\", \"userID\": \"tester1\", \"receiver\": \"tester2\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/messages")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}