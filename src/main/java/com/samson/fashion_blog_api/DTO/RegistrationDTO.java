package com.samson.fashion_blog_api.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegistrationDTO {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
