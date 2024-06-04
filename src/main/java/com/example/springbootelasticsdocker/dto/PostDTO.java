package com.example.springbootelasticsdocker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PostDTO {
    private String title;
    private String description;
    private Date createAt;
}
