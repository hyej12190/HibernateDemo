package com.example.hibernateTest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TB_USER")
public class User {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "FIRST")
    private String first;

    @Column(name = "LAST")
    private String last;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PWD")
    private String pwd;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="GROUP_CD")
    private UserGroup userGroup;
}
