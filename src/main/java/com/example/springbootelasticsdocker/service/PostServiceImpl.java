package com.example.springbootelasticsdocker.service;

import com.example.springbootelasticsdocker.dto.PostDTO;
import com.example.springbootelasticsdocker.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootelasticsdocker.repository.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
        Iterable<Post> posts = postRepository.findAll();
        List<Post> postList = new ArrayList<>();
        posts.forEach(postList::add);
        return postList;
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(String id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post savePost(PostDTO postDTO) {
        Post post = Post.builder()
                        .title(postDTO.getTitle())
                        .description(postDTO.getDescription())
                        .createAt(new Date())
                        .build();
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(String id, PostDTO postDTO) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setTitle(postDTO.getTitle());
            post.setDescription(postDTO.getDescription());
            return postRepository.save(post);
        } else {
            return null;
        }
    }
}
