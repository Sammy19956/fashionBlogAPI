package com.samson.fashion_blog_api.Service.ServiceImpl;

import com.samson.fashion_blog_api.Model.Comment;
import com.samson.fashion_blog_api.Model.Post;
import com.samson.fashion_blog_api.Repository.CommentRepository;
import com.samson.fashion_blog_api.Repository.PostRepository;
import com.samson.fashion_blog_api.Service.CommentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    @Override
    public Post writeComment(Long post_id,String message) {
        Post post = postRepository.findById(post_id).orElse(null);
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setMessage(message);
        comment.setDate(LocalDateTime.now());
        comment.setPost(post);
        commentList.add(comment);
        assert post != null;
        post.setComments(commentList);

        commentRepository.save(comment);
        return postRepository.save(post);
    }
}
