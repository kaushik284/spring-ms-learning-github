package com.question.service;

import java.util.List;

import com.question.entity.Question;

public interface QuestionService {
	
	Question create(Question question);
	
	List<Question> getAll();

	Question get(Long id);
	
	List<Question> getByQuizId(Long quizId);
}
