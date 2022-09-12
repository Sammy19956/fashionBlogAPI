package com.samson.fashion_blog_api.Service;


import com.samson.fashion_blog_api.Model.Comment;
import com.samson.fashion_blog_api.Model.Post;

public interface CommentService  {

    Post writeComment(Long post_id, String message);
}
