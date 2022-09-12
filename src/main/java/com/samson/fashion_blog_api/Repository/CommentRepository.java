package com.samson.fashion_blog_api.Repository;

import com.samson.fashion_blog_api.Model.Comment;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "delete from user_comments where post_id = ?1", nativeQuery = true)
     void deleteCommentById(Long commentId);
}
