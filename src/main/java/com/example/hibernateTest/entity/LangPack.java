package com.example.hibernateTest.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * LangPack
 */
@Entity
@Data
@Table(name = "TB_LANG_PACK")
public class LangPack {

    @EmbeddedId
    private LangPackPK pk;

    private String LANG_VALUE;
}