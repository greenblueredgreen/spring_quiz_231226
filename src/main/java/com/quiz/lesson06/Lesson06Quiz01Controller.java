package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	//http://localhost:8080/lesson06/quiz01/add-website-view
	@GetMapping("/add-website-view")
	public String addWebSiteView() {
		return "lesson06/addWebSite";
	}
	
	@GetMapping("/list-website-view")
	public String listWebSiteView() {
		return "lesson06/listWebSite";
	}
}
