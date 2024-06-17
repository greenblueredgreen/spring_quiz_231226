package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //html view
public class Lesson01Quiz03Controller {
	
	//http://localhost:8080/lesson01/quiz03/1
	@RequestMapping("lesson01/quiz03/1")
	public String quiz03() {
		
		//@ResponseBody가 아닌 상태로 return String을 하면
		//ViewResolver에 의해 return 된 String jsp경로를 찾고
		// jsp => html 화면으로 구성된다. 
		return "lesson01/quiz03"; //jsp view 경로
	}
	
	
	
	// Request
	//http://localhost:8080/lesson01/quiz03/2
	@RequestMapping("/lesson01/quiz03/2")
	public String quiz03_2() {
		//@ResponseBody가 아닌 상태로 return String을 하면 
		// viewResolver에 의해 리턴된 html 경로를 찾아서 화면이 구성된다.
		
		
		//Response
		// return "/templates/lesson01/quiz03.html //html경로와 연결된다.
		return "lesson01/quiz03";
	}
}
