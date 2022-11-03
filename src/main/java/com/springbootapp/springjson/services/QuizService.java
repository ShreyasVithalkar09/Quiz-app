package com.springbootapp.springjson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapp.springjson.model.Question;
import com.springbootapp.springjson.model.UserResponse;
import com.springbootapp.springjson.repository.QuizRepository;
//import com.springbootapp.springjson.repository.UserDataRepository;
//import com.springbootapp.springjson.repository.UserResponseRepository;
import com.springbootapp.springjson.repository.UserResponseRepository;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;

	@Autowired
	UserResponseRepository userResponseRepository;
	int marks = 0;
	int score = 0;
	
	public List<Question> getAllQuestions(){
		return quizRepository.findAll();
	}
	
	public int validateResponse(List<UserResponse> userResponse) {
		
		for(UserResponse res: userResponse) {
			Optional<Question> q = quizRepository.findById(res.getId());	
			Question question = q.get();
			if(res.getSelected().equalsIgnoreCase(question.getAnswer())) {
				marks+=10;
			}
			
		}
		

		return marks;	
	}
	
	public void submitResponse(List<UserResponse> userResponse) {
//		
		
		for(UserResponse res: userResponse) {

			
			userResponseRepository.save(res);
			
		}
		

	}
	
	
	public String addQuestions(List<Question> questions)
	{
		for(Question q: questions) {
			quizRepository.save(q);
		}
		
		return "Data inserted successfully";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
