package com.samson.fashion_blog_api.ApiResponse;

import com.samson.fashion_blog_api.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationResponse {

        private String message;
        private User user;
}
