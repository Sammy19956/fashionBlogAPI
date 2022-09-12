package com.samson.fashion_blog_api.Repository;

import com.samson.fashion_blog_api.Model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
