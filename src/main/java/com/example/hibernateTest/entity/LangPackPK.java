package com.example.hibernateTest.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * LangPackPK
 */
@Embeddable
@Data
public class LangPackPK implements Serializable {

    private static final long serialVersionUID = 1L;

    /* First Primary Key */
    private String LOCALE;

    /* Second Primary Key */
    private String LANG_KEY;
}