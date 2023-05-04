package com.example.webservice.postservicews.service;

import com.example.webservice.postservicews.dto.PostDTO;

public interface PostService {
    PostDTO findById(String id);
}
