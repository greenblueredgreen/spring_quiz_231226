package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Quiz03RestController {
	
	@Autowired  //bo를 얻어오기 위해 어노테이션 사용
	private RealEstateBO realEstateBO;
	
	
	//quiz 는 8080
	//http://localhost:8080/lesson03/quiz03/1?id=8&type=전세&price=70000
	@RequestMapping("/lesson03/quiz03/1")
	public String quiz03_1(  
			
			//input자리에 넣어야한다.
			//쿼리스트링에 필수 파라미터로 들어가 있기 때문에 타입, id, price는 필수 파라미터이다.
		@RequestParam("id") int id,   //null이 아니기 때문에 int로 한다.
		@RequestParam("type") String type, 
		@RequestParam("price") int price) {
		
		int rowCount = realEstateBO.updataRealEstateById(id, type, price);
		return "수정 성공 : " + rowCount;  //HTML 로 응답
	}
}
