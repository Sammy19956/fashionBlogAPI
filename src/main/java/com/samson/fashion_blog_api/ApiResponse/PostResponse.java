package com.samson.fashion_blog_api.ApiResponse;

import com.samson.fashion_blog_api.Model.Comment;
import com.samson.fashion_blog_api.Model.Post;
import com.samson.fashion_blog_api.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public class PostResponse {

  private Post post;
//  private User user;

}
