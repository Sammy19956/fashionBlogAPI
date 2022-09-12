package com.samson.fashion_blog_api.Controller;

import com.samson.fashion_blog_api.ApiResponse.PostResponse;
import com.samson.fashion_blog_api.DTO.PostDTO;
import com.samson.fashion_blog_api.Model.Comment;
import com.samson.fashion_blog_api.Model.Post;
import com.samson.fashion_blog_api.Model.User;
import com.samson.fashion_blog_api.Service.CommentService;
import com.samson.fashion_blog_api.Service.PostService;
import com.samson.fashion_blog_api.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RestController
public class PostController {

    @Autowired
    PostService postService;

    private final CommentService commentService;
    private final UserService userService;

    @PostMapping ("/{id}/post")
    public ResponseEntity<PostResponse> writePost(@RequestBody PostDTO postDTO, @PathVariable("id") Long id){
        return postService.writePost(postDTO, id);

    }

    @PostMapping("/{user_id}/delete-post/{post_id}")
    public User deletePost(@PathVariable("user_id") Long user_id, @PathVariable("post_id") Long post_id){
//        User user = userService.findUserById(user_id);
//      List<Post> postList = user.getPosts();
//      Post newPost= new Post();
//        for(Post ps: postList){
//            if(ps.getId() == user_id){
//                newPost = ps;
//            }
//        }
        User user = userService.findUserById(user_id);
        postService.deletePost(post_id);
        return user;
    }
    @PutMapping("/{user_id}/{post_id}/update-post")
    public ResponseEntity<PostResponse> updatePost(@PathVariable("user_id") Long user_id, @PathVariable("post_id") Long post_id, @RequestBody PostDTO postDTO){
        return postService.updatePost(postDTO,user_id, post_id);
    }

    @PostMapping("/{post_id}/comment")
    public Post writeComment(@PathVariable("post_id") Long post_id, @RequestBody String message){
        return commentService.writeComment(post_id, message);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> searchPost(@RequestParam("keyword") String keyword){
        System.out.println(keyword);
        return postService.searchPost(keyword);
    }


}











