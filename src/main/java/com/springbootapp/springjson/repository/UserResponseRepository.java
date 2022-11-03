package com.springbootapp.springjson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootapp.springjson.model.UserResponse;

public interface UserResponseRepository extends JpaRepository<UserResponse, Integer> {

}
