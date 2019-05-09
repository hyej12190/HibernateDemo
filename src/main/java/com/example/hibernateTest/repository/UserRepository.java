package com.example.hibernateTest.repository;

import com.example.hibernateTest.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
