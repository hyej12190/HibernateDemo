package com.example.hibernateTest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TB_USER")
public class User {

    @Id
    @Column(name = "ID")
    private String ID;

    @Column(name = "FIRST")
    private String FIRST;

    @Column(name = "LAST")
    private String LAST;

    @Column(name = "EMAIL")
    private String EMAIL;

    @Column(name = "PWD")
    private String PWD;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="GROUP_CD")
    private UserGroup userGroup;
}
