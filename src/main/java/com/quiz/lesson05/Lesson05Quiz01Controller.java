package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Quiz01Controller {
	
	//http://localhost:8080/lesson05/quiz01
	@GetMapping("/quiz01")
	public String ex01() {
		return "lesson05/quiz01";
	}
}
