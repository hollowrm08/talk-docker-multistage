package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_student")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends User {

    @Column(name = "s_enrollment")
    private String enrollment;

    //Todo: add parameter class

}
