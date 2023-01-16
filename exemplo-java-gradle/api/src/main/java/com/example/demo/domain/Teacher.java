package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_teacher")
@Inheritance(strategy = InheritanceType.JOINED)
public class Teacher extends User{

    @Column(name = "s_siape")
    private String siape;

    //Todo: add parameters: subjects, classes, commentaries and topics?

}
