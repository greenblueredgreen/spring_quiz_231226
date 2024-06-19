package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;


@RestController // @Controller + @ResponseBody //spring bean으로 등록
public class Lesson02QuizRestController {
	
	@Autowired
	private StoreBO storeBO;
	
	//http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01(){
		return storeBO.getStoreList(); //json String
	}
}
