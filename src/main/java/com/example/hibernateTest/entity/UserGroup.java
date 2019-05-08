package com.example.hibernateTest.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "TB_USER_GROUP")
public class UserGroup {

   @Id
   @GeneratedValue
   @Column(name = "GROUP_CD")
   private String GROUP_CD;

   @Column(name = "GROUP_NM")
   private String GROUP_NM;

   @Column(name = "USE_YN")
   private char USE_YN;

}
