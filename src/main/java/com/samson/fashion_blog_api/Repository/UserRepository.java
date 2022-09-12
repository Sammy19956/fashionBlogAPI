package com.samson.fashion_blog_api.Repository;

import com.samson.fashion_blog_api.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select *from users where email =?1 and password = ?2", nativeQuery = true)
    User findByEmailAndPassword(String email, String password);


    @Query(value = "select * from users where email = ?1", nativeQuery = true)
    User findByUserName(String username);
}
