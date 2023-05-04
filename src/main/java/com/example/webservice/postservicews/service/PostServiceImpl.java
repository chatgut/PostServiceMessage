package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.exception.PostNotFoundException;
import com.example.webservice.postservicews.Post;
import com.example.webservice.postservicews.dto.PostDTO;
import com.example.webservice.postservicews.dto.newDTO;
import com.example.webservice.postservicews.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    PostServiceImpl (PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post save(newDTO newDTO) {
        Post post = new Post();
        return postRepository.save(post);
    }

    @Override
    public PostDTO findById(String id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
        return getPostDto(post);
    }

    private PostDTO getPostDto(Post post) {
        return new PostDTO();
    }

}
