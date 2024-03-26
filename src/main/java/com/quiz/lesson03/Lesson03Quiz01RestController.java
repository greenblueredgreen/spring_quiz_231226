package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO; //BO에 요청
	
	@RequestMapping("/1")
	//http://localhost:8080/lesson03/quiz01/1?id=20
	public RealEstate quiz01_1(
		@RequestParam("id") int id
		){
		return realEstateBO.getRealEstateById(id);
	}
	
	
	// http://localhost:8080/lesson03/quiz01/2?rent_price=90
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam(value = "rent_price", required = true) int rentPrice) {
			
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
}
