package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {
	
	// 쿼리문인 insert로 바꿔준다. 
	public void insertSeller(
			// 파라미터 여러 개이므로 map으로!
			// map이 되려면 어노테이션 @Param()을 해준다.
			// 변수명 달라도 괜찮다. 
			@Param("nickname") String nickname, 
			@Param("profileImage") String profileImage, 
			@Param("temperature") double temperature);
	
	//get을 select로 바꿔준다. (조회일 때)
	public Seller selectLatestSeller();
	
	//파람어노테이션 안붙여도 된다. 하나이기 때문에 안붙임
	public Seller selectSellerById(int id);
}
