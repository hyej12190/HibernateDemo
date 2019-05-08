package com.example.hibernateTest.repository;

import java.util.List;

import com.example.hibernateTest.entity.User;
import com.example.hibernateTest.entity.UserMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, String> {

    List<UserMapping> findAllBy();
    
    @Modifying
    @Transactional
    @Query(value = "delete from TB_USER where id = ?1", nativeQuery = true)
    void deleteByUserId(String id);

    // @Query(value = "select T.ID, T.FIRST from USER t", nativeQuery =  true)
    // List<User> findByUsers();

}
