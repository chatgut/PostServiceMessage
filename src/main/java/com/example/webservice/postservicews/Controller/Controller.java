package com.example.webservice.postservicews.Controller;

import com.example.webservice.postservicews.dto.PostDTO;
import com.example.webservice.postservicews.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController ("api/post")
public class Controller {

    private final PostService postService;

    public Controller(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getMessageById(@PathVariable("id") String id) {
        PostDTO postDto = postService.findById(id);
        return ResponseEntity.ok(postDto);
    }

}
