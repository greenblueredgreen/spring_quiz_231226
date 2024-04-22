package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired  //@Autowired통해서 mapper에 접근(클래스 안만든다)
	private SellerMapper sellerMapper;
	
	
	// input : 3개 파라미터(nickname,image,temper) 가 controller로부터 넘어온다.
	// output : x (안줘도 상관없음)
	public void addSeller(String nickname, String profileImage, double temperature) {
		sellerMapper.insertSeller(nickname, profileImage, temperature);
	}
	
	//	input : x
	// output : Seller or null 
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	// id를 parameter로 받는 메소드
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}
