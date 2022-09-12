package com.samson.fashion_blog_api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer islike;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

//    @ManyToOne
//    @JsonBackReference
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
}





