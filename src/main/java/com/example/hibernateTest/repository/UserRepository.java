package com.example.hibernateTest.repository;

import java.util.List;

import com.example.hibernateTest.entity.User;
import com.example.hibernateTest.entity.UserMapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    List<UserMapping> findAllBy();

    Page<User> findAll(Pageable pageable);



    // @Query(value = "select T.ID, T.FIRST from USER t", nativeQuery =  true)
    // List<User> findByUsers();

}
