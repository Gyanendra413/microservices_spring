package com.quiz.controllers;

import java.util.List;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@GetMapping
	public List<Quiz> getAllQuizzes(){
		return quizService.getAllQuizzes();
	}
	
	@GetMapping("/{id}")
	public Quiz getQuizById(@PathVariable Long id) {
		return quizService.getQuizByID(id);
	}
	
	@PostMapping
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return quizService.addQuiz(quiz);
	}
}
