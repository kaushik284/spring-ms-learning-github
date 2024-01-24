package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.Quiz;
import com.quiz.service.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

	private final QuizService service;
	
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return service.add(quiz);
	}
	
	@GetMapping
	public List<Quiz> get(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Quiz get(@PathVariable Long id){
		return service.get(id);
	}
}
