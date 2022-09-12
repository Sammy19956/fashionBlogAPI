package com.samson.fashion_blog_api.Service.ServiceImpl;

import com.samson.fashion_blog_api.ApiResponse.LoginResponse;
import com.samson.fashion_blog_api.ApiResponse.RegistrationResponse;
import com.samson.fashion_blog_api.DTO.LoginDTO;
import com.samson.fashion_blog_api.DTO.RegistrationDTO;
import com.samson.fashion_blog_api.Model.User;
import com.samson.fashion_blog_api.Repository.UserRepository;
import com.samson.fashion_blog_api.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public ResponseEntity<RegistrationResponse> registerUser(RegistrationDTO regDTO) {
        User user = new User();
        user.setFirstname(regDTO.getFirstname());
        user.setLastname(regDTO.getLastname());
        user.setEmail(regDTO.getEmail());
        user.setPassword(regDTO.getPassword());
        return new ResponseEntity<>(new RegistrationResponse("Registration Successful!!!", userRepository.save(user)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<LoginResponse> findByEmailAndPassword(LoginDTO loginDTO) {
        User user = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if(user != null){
            return new ResponseEntity<>(new LoginResponse("Login Successful!!!", HttpStatus.OK, user), HttpStatus.OK);
        }
        return new ResponseEntity<>(new LoginResponse("Login failed!!!", HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);

    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
