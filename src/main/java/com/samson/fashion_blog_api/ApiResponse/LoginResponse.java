package com.samson.fashion_blog_api.ApiResponse;

import com.samson.fashion_blog_api.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

    private String message;
    private HttpStatus status;
    private User user;

    public LoginResponse(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
