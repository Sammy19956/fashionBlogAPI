package com.samson.fashion_blog_api.Service;

import com.samson.fashion_blog_api.ApiResponse.LoginResponse;
import com.samson.fashion_blog_api.ApiResponse.RegistrationResponse;
import com.samson.fashion_blog_api.DTO.LoginDTO;
import com.samson.fashion_blog_api.DTO.RegistrationDTO;
import com.samson.fashion_blog_api.Model.User;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public interface UserService {
     ResponseEntity<RegistrationResponse> registerUser(RegistrationDTO regDTO);
     ResponseEntity<LoginResponse> findByEmailAndPassword(LoginDTO loginDTO);

     User findUserById(Long id);

}
