package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_login")
    private String login;

    @Column(name = "s_email")
    private String email;

    @Column(name = "s_password")
    private String password;

    @Column(name = "s_bio")
    private String bio;

    @Column(name = "d_birthday")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    //Todo: add parameter posts and comments?

}
