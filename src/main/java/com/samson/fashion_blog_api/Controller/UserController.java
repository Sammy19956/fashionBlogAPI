package com.samson.fashion_blog_api.Controller;

import com.samson.fashion_blog_api.ApiResponse.LoginResponse;
import com.samson.fashion_blog_api.ApiResponse.RegistrationResponse;
import com.samson.fashion_blog_api.DTO.LoginDTO;
import com.samson.fashion_blog_api.DTO.RegistrationDTO;
import com.samson.fashion_blog_api.Model.User;
import com.samson.fashion_blog_api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.ResultSet;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody RegistrationDTO regDTO, BindingResult result){

        if(result.hasErrors()){
            return new ResponseEntity<>(new RegistrationResponse("Registration failed!!!", new User()), HttpStatus.OK);
        }
        return userService.registerUser(regDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO loginDTO, HttpSession session){
        session.setAttribute("user", new User());
        return userService.findByEmailAndPassword(loginDTO);

    }

}
