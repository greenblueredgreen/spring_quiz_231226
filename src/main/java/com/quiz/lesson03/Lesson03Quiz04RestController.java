package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Quiz04RestController {
	
	@Autowired 
	private RealEstateBO realEstateBO; //BO로 접근하기 위해
	
	//http://localhost:8080/lesson03/quiz04/1?id=12
	// id가 12번인 것 삭제하기
	@RequestMapping("lesson03/quiz04/1")
	public String quiz04_1(
			@RequestParam("id") int id
			) {
		int rowCount = realEstateBO.deleteRealEstateById(id);
		return "삭제 성공 : " + rowCount;
	}
}
