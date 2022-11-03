package com.springbootapp.springjson.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.springjson.model.Question;
import com.springbootapp.springjson.model.UserResponse;
import com.springbootapp.springjson.services.QuizService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://127.0.0.1:4200/")
public class DataController {
	
	@Autowired
	QuizService quizService;
	
	@GetMapping("/questions")
	public List<Question> getAllQuestions(){
		return quizService.getAllQuestions();
	}
	
	@PostMapping(value="/submit", consumes= { "application/json"})
	public int submitResponse(@RequestBody List<UserResponse> userResponse) {
		quizService.submitResponse(userResponse);
		return quizService.validateResponse(userResponse);
	
		
	}
	
	
	@PostMapping("/add")
	public String addQuestions(@RequestBody List<Question> questions) {
		return quizService.addQuestions(questions);
	}


}
