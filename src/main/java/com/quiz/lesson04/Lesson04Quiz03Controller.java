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

@RequestMapping("/lesson04/quiz03")
@Controller
public class Lesson04Quiz03Controller {
	
	@Autowired
	RealtorBO realtorBO;
	
	//초기화면 출력
	@GetMapping("add-realtor-view")
	//http://localhost:8080/lesson04/quiz03/add-realtor-view
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	//http://localhost:8080/lesson04/quiz03/add-realtor
	@PostMapping("/add-realtor")
	public String addRealtor(
		@ModelAttribute Realtor realtor,
		Model model){
		
		// DB INSERT
		realtorBO.addRealtor(realtor);
		
		// DB SELECT
		int id = realtor.getId();
		Realtor newRealtor = realtorBO.getRealtorById(id);
		
		// model에 넣기
		model.addAttribute("realtor", newRealtor); 
		//select된 해당된 id 정보 newRealtor을 
		// model "realtor"에 넣기
		// 넣은 다음, thymeleaf를 통해서 보여주기 
		
		return "lesson04/afterAddRealtor";
	}
}
