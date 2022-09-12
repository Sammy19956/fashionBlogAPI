package com.samson.fashion_blog_api.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDTO {
    private String title;
    private String message;

}
