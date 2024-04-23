package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	
	@Autowired
	RealtorBO realtorBO;
	
	//가장 먼저 보이는 화면
	//http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	//post
	//http://localhost:8080/lesson04/quiz02/add-realtor
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model
			) {
		
		//DB INSERT
		realtorBO.addRealtor(realtor);
		
		//DB SELECT => 방금 가입된 Realtor
		int id = realtor.getId(); //Realtor 도메인에서 가져온다.
		Realtor newRealtor = realtorBO.getRealtorById(id);
		
		//model에 담기
		model.addAttribute("realtor", newRealtor);
		
		//화면 이동
		return "lesson04/afterAddRealtor";
	}
}
