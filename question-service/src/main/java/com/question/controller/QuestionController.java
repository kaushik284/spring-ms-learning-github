package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

	private final QuestionService service;
	
	@PostMapping
	public Question create(@RequestBody Question q) {
		return service.create(q);
	}
	
	@GetMapping
	public List<Question> get(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Question get(@PathVariable Long id) {
		return service.get(id);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsByQuiz(@PathVariable Long quizId){
		return service.getByQuizId(quizId);
	}
}
