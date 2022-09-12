package com.samson.fashion_blog_api.Service;

import com.samson.fashion_blog_api.ApiResponse.DeleteResponse;
import com.samson.fashion_blog_api.ApiResponse.PostResponse;
import com.samson.fashion_blog_api.DTO.PostDTO;
import com.samson.fashion_blog_api.Model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    ResponseEntity<PostResponse> writePost(PostDTO postDTO, Long id);

    Post findPostById(Long id);

    ResponseEntity<DeleteResponse> deletePost(Long post_id);

    ResponseEntity<PostResponse> updatePost(PostDTO postDTO, Long user_id, Long post_id);

    ResponseEntity<List<Post>> searchPost(String keyword);

    ResponseEntity<PostResponse> likePost(Long post_id);
}










