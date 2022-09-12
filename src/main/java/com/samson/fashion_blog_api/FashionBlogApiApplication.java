package com.samson.fashion_blog_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FashionBlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FashionBlogApiApplication.class, args);
    }

}
