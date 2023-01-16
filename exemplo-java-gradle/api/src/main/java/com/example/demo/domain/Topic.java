package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb_topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "s_content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "s_privacy")
    private Privacy privacy;

    @Column(name = "t_creation")
    private LocalDateTime dateOfCreation;

    @Enumerated(EnumType.STRING)
    @Column(name = "s_type_author")
    private TypeAuthor typeAuthor;

    @Column(name = "s_path_image")
    private String pathImage;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private User author;

}
