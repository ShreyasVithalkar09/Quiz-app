package com.springbootapp.springjson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootapp.springjson.model.Question;

@Repository
public interface QuizRepository extends JpaRepository<Question, Integer> {

}
