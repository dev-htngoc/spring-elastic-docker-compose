package com.example.springbootelasticsdocker.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Builder
@Document(indexName = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String description;
    private Date createAt;
}
