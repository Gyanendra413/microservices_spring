package com.quiz.entities;
import lombok.Data;

@Data
public class Question {

	private Long questionId;
	private String question;
	private Long quizId;
}
