package com.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Quiz_test")
public record QuizTest(
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id, 
		String quizName, String quizType, Integer totalQuestions) {

}
