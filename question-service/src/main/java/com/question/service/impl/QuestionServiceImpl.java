package com.question.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.repo.QuestionRepo;
import com.question.service.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	private final QuestionRepo repo;
	
	@Override
	public Question create(Question question) {
		return repo.save(question);
	}

	@Override
	public List<Question> getAll() {
		return repo.findAll();
	}

	@Override
	public Question get(Long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getByQuizId(Long quizId) {
		return repo.findByQuizId(quizId);
	}

}
