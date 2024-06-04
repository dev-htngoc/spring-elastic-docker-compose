package com.example.springbootelasticsdocker.controller;

import com.example.springbootelasticsdocker.dto.PostDTO;
import com.example.springbootelasticsdocker.model.Post;
import com.example.springbootelasticsdocker.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@RequestBody PostDTO postDTO) {
        return postService.savePost(postDTO);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPost());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        Post post = postService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody PostDTO postDTO) {
        Post updatedPost = postService.updatePost(id, postDTO);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable String id) {
        postService.deletePost(id);
        return ResponseEntity.ok("delete successfully!");
    }
}
