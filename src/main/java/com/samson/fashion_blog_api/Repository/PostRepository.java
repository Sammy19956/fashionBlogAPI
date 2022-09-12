package com.samson.fashion_blog_api.Repository;

import com.samson.fashion_blog_api.Model.Post;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "delete from posts where id = ?1", nativeQuery = true)
    void deletePostById(Long post_id);

    @Query(value = "SELECT * from posts where title like %:in%gi", nativeQuery = true)
    List<Post> searchPost(@Param("in") String keyword);

}


