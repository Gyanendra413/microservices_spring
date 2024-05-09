package com.question.services;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

	public List<Question> getAllQuestions();
	public Question getQuestionById(Long id);
	public Question addQuestion(Question question);
	public List<Question> getQuestionsByQuizId(Long quizId);
}
