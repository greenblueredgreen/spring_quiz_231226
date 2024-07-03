package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController  //json으로 내려간다.
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {

	@Autowired
	private CompanyBO companyBO;
	
	//http://localhost:8080/lesson07/quiz01/save1
	@GetMapping("/save1")
	public CompanyEntity create() {
		
		//insert할 값
		//String name = "넥손";
		//String business ="콘텐츠 게임";
		//String scale = "대기업";
		//int headcount = 3585;
		
		//return companyBO.addCompany(name, business, scale, headcount);
		return companyBO.addCompany("넥손", "콘텐츠 게임", "대기업", 3585); //바로 리턴 가능
	}
	
	//http://localhost:8080/lesson07/quiz01/save2
	@GetMapping("/save2")
	public CompanyEntity create2() {
		
		//insert할 값
//		String name = "버블팡";
//		String business ="여신 금융업";
//		String scale = "대기업";
//		int headcount = 6834;
		
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}
	
	//http://localhost:8080/lesson07/quiz01/update
	@GetMapping("/update")
	public CompanyEntity update() {
		//id : 2번, 규모 - 중소기업, 인원수 34
		//하나의 행을 바로 리턴 -> 응답 내려감 -> json
		return companyBO.updateCompanyById(2, "중소기업", 34);
	}
	
	//http://localhost:8080/lesson07/quiz01/delete
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteCompanyById(2);
		
		return "삭제 성공";
	}
}
