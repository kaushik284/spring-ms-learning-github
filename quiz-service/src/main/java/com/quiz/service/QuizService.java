package com.quiz.service;

import java.util.List;

import com.quiz.entity.Quiz;

public interface QuizService {
	
	Quiz add(Quiz quiz);
	
	List<Quiz> getAll();

	Quiz get(Long id);
}
