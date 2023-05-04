package com.example.webservice.postservicews;

import com.example.webservice.postservicews.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController ("api/post")
public class Controller {

    private final PostService postService;

    public Controller(PostService postService){
        this.postService = postService;
    }

}
