package com.quiz.services.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired 	
	private QuestionClient questionClient;

	@Override
	public List<Quiz> getAllQuizzes() {
		List<Quiz> quizzes = quizRepository.findAll();
		
		List<Quiz> quizList = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return quizList;
	}

	@Override
	public Quiz getQuizByID(Long id) {
		Quiz quiz = quizRepository.findById(id).orElse(null);
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
		return quiz;
	}

	@Override
	public Quiz addQuiz(Quiz quiz) {
		Quiz request = quizRepository.save(quiz);
		return request;
	}

}
