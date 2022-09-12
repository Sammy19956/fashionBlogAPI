package com.samson.fashion_blog_api.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class DeleteResponse {
    private String message;
    private LocalDateTime date;
}
