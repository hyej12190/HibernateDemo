package com.example.hibernateTest.repository;

import com.example.hibernateTest.entity.LangPack;
import com.example.hibernateTest.entity.LangPackPK;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LangPackRepository
 */
public interface LangPackRepository extends JpaRepository<LangPack, LangPackPK> {
    
}