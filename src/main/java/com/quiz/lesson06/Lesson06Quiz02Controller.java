package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {
	
	@GetMapping("add-url-view")
	public String addUrlView() {
		return "lesson06/addUrlView";
	}
}
