package com.quiz.services;

import java.util.List;

import com.quiz.entities.Quiz;

public interface QuizService {
	
	List<Quiz> getAllQuizzes();
	Quiz getQuizByID(Long id);
	Quiz addQuiz(Quiz quiz);

}
