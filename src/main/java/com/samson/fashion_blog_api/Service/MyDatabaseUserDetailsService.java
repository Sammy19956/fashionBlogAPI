package com.samson.fashion_blog_api.Service;

import com.samson.fashion_blog_api.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyDatabaseUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

//    DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler;
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        defaultWebSecurityExpressionHandler.setDefaultRolePrefix("RL_");
//        defaultWebSecurityExpressionHandler.
//       User user = userRepository.findByUserName(username);
//        List<SimpleGrantedAuthority> grantedAuthorities = user.getAuthorities().stream().map()
//    }
}
