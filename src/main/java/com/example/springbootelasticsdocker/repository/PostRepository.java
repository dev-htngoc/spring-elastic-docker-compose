package com.example.springbootelasticsdocker.repository;

import com.example.springbootelasticsdocker.model.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ElasticsearchRepository<Post, String> {
}
