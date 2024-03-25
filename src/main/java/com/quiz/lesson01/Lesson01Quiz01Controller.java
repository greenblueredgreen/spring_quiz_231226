package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller
public class Lesson01Quiz01Controller {
	
	
	@RequestMapping("/1")
	@ResponseBody
	public String ex01_1() {
		return "<h1>테스트 프로젝트 완성</h2>"
				+ "<br>"
				+ "<p>해당 프로젝트를 통해서 문제풀이를 진행합니다. </p>";
	}
	
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> ex01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("수학", 90);
		map.put("영어", 85);
		return map; //map -> json
	}
}
