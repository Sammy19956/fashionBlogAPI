package com.samson.fashion_blog_api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    @NotBlank(message = "email cannot be empty")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "password cannot be empty")
    private String password;

//    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Post> posts;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "user")
//    private List<Comment> comments;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "user")
//    private List<Like> likeList;
}
