
package com.example.hibernateTest.repository;

import com.example.hibernateTest.entity.UserGroup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup, String> {

}
