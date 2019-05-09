package com.example.hibernateTest.repository;

import com.example.hibernateTest.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, String> {

    // @Modifying
    // @Transactional
    // @Query(value = "delete from TB_USER where id = ?1", nativeQuery = true)
    // void deleteByUserId(String id);

}
