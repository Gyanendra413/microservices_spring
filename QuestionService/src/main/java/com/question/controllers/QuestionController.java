package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping
	public List<Question> getAllQuestions() {
		List<Question> questions = questionService.getAllQuestions();
		return questions;
	}

	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable Long id) {
		Question request = questionService.getQuestionById(id);
		return request;
	}

	@PostMapping
	public Question addQuestion(@RequestBody Question question) {
		Question request = questionService.addQuestion(question);
		return request;
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
		List<Question> questions = questionService.getQuestionsByQuizId(quizId);
		return questions;
	}
}
