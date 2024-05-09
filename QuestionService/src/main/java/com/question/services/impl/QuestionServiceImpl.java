package com.question.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.question.entities.Question;
import com.question.repositories.QuestionRepo;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public List<Question> getAllQuestions() {
		List<Question> questions = questionRepo.findAll();
		return questions;
	}

	@Override
	public Question getQuestionById(Long id) {
		Question request = questionRepo.findById(id).orElse(null);
		return request;
	}

	@Override
	public Question addQuestion(Question question) {
		Question request = questionRepo.save(question);
		return request;
	}

	@Override
	public List<Question> getQuestionsByQuizId(Long quizId) {
		List<Question> questions = questionRepo.findByQuizId(quizId);
		return questions;
	}

}
