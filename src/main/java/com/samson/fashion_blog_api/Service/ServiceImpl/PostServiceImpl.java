package com.samson.fashion_blog_api.Service.ServiceImpl;

import com.samson.fashion_blog_api.ApiResponse.DeleteResponse;
import com.samson.fashion_blog_api.ApiResponse.PostResponse;
import com.samson.fashion_blog_api.DTO.PostDTO;
import com.samson.fashion_blog_api.Model.Like;
import com.samson.fashion_blog_api.Model.Post;
import com.samson.fashion_blog_api.Model.User;
import com.samson.fashion_blog_api.Repository.CommentRepository;
import com.samson.fashion_blog_api.Repository.LikeRepository;
import com.samson.fashion_blog_api.Repository.PostRepository;
import com.samson.fashion_blog_api.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import java.time.LocalDateTime;

//@NoArgsConstructor
@AllArgsConstructor

@Service
public class PostServiceImpl implements com.samson.fashion_blog_api.Service.PostService {


    private final PostRepository postRepository;

   private final UserService userService;

   private final CommentRepository commentRepository;

   private final LikeRepository likeRepository;

    @Override
    public ResponseEntity<PostResponse> writePost(@RequestBody PostDTO postDTO, Long id){

        User user = userService.findUserById(id);
          Post post = new Post();
          post.setTitle(postDTO.getTitle());
          post.setMessage(postDTO.getMessage());
          post.setCreatedAt(LocalDateTime.now());
          post.setUser(user);
          postRepository.save(post);
          return new ResponseEntity<>(new PostResponse(post), HttpStatus.OK);
      }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<DeleteResponse> deletePost(Long post_id){
        Post post = postRepository.findById(post_id).orElse(null);
//        commentRepository.deleteCommentById(post.getId());
        postRepository.delete(post);
        return new ResponseEntity<>(new DeleteResponse("Post successfully deleted", LocalDateTime.now()), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<PostResponse> updatePost(PostDTO postDTO, Long user_id, Long post_id) {

        User user = userService.findUserById(user_id);
        Post post = findPostById(post_id);
        post.setTitle(postDTO.getTitle());
        post.setMessage(postDTO.getMessage());
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(user);
        post.setComments(post.getComments());
        post.setLikes(post.getLikes());
        return new ResponseEntity<>(new PostResponse(post), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Post>> searchPost(@RequestParam("") String keyword) {
       List<Post> post = postRepository.searchPost(keyword);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostResponse> likePost(Long post_id) {
return null;
    }

}
