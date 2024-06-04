package com.example.springbootelasticsdocker.service;

import com.example.springbootelasticsdocker.dto.PostDTO;
import com.example.springbootelasticsdocker.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPost();
    Post getPostById(String id);
    void deletePost(String id);
    Post savePost(PostDTO postDTO);
    Post updatePost(String id, PostDTO postDTO);
}
