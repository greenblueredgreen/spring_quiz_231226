package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	//spring bean
	@Autowired  //@Autowired통해서 mapper에 접근(클래스 안만든다)
	private SellerMapper sellerMapper;
	
	// input : 3개 파라미터(nickname,image,temper) 가 controller로부터 넘어온다.
	// output : x (안줘도 상관없음)
	// 변수명 다르게 해도 괜찮다.  bo에서만 사용하는 것이다. 
	public void addSeller(String nickname, String profileImage111, double temperature) {
		sellerMapper.insertSeller(nickname, profileImage111, temperature);
											//bo안에 있는 변수(이상한 변수) 사용된다.
	}
	
	
	//	input : x
	// output : Seller or null  (채워져있거나 null 이다.)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	// id를 parameter로 받는 메소드
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}
