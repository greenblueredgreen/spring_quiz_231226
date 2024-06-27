package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	//http://localhost:8080/lesson06/quiz01/add-website-view
	@GetMapping("/add-website-view")
	public String addWebSiteView() {
		return "lesson06/addWebSite";
	}
	
	//http://localhost:8080/lesson06/quiz01/list-website-view
	@GetMapping("/list-website-view")
	public String listWebSiteView() {
		return "lesson06/listWebSite";
	}
	
	@ResponseBody
	@PostMapping("/add-website")
	public String addWebSite(
			@RequestParam("title") String title,
			@RequestParam("link") String link
			) {
		
		// db insert
		
		// ajax응답
		// "성공"
		return "성공";
	}
}
