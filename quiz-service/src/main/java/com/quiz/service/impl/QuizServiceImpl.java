package com.quiz.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entity.Quiz;
import com.quiz.repo.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {

	private final QuizRepository quizRepository;
	
	private final QuestionClient questionClient;

	@Override
	public Quiz add(Quiz quiz) {

		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		List<Quiz> quizes = quizRepository.findAll();
		return quizes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		 
	}

	@Override
	public Quiz get(Long id) {
		Quiz found = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		found.setQuestions(questionClient.getQuestionOfQuiz(found.getId()));
		
		return found;
	}

}
